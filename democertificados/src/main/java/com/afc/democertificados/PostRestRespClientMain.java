/**
 * 
 */
package com.afc.democertificados;
import com.afc.democertificados.models.ByMonth;
import com.afc.democertificados.models.Datum;
import com.afc.democertificados.models.DetalleAportantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kong.unirest.HttpResponse;
import kong.unirest.JsonObjectMapper;
import kong.unirest.Unirest;

import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 * @author Madre Hermosa
 *
 */
public class PostRestRespClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Configurar el ObjectMapper de Unirest con Gson
        Unirest.config().setObjectMapper(new JsonObjectMapper() {
            private final Gson gson = new Gson();

            public <T> T readValue(String value, Type type) {
                return gson.fromJson(value, type);
            }

            @Override
            public String writeValue(Object value) {
                return gson.toJson(value);
            }
        });

        // Configurar el token de portador (bearer token)
        String bearerToken = "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0";

        // URL de la API REST
        String apiUrl = "https://api.floid.app/cl/afc/detalle_aportantes";

        // Cuerpo de la solicitud
        String requestBody = "{\"id\":\"11111111-1\",\"password\":\"1234\", \"sandbox\":\"true\"}";

        // Realizar la solicitud POST con Unirest
        HttpResponse<String> response = Unirest.post(apiUrl)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .asString();

        // Verificar el código de respuesta HTTP
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            // La solicitud fue exitosa
            String responseBody = response.getBody();
            // Mapear el resultado utilizando las clases proporcionadas
            DetalleAportantes detalleAportantes = new Gson().fromJson(responseBody, DetalleAportantes.class);
            // Imprimir el resultado
            System.out.println("Código: " + detalleAportantes.getCode());
            System.out.println("Mensaje: " + detalleAportantes.getMsg());
            System.out.println("Case ID: " + detalleAportantes.getCaseid());
            ArrayList<Datum> data = detalleAportantes.getData();
            if (data != null) {
                for (Datum datum : data) {
                    System.out.println("RUT Empleador: " + datum.getRut_employer());
                    System.out.println("Nombre de la empresa: " + datum.getCompany_name());
                    System.out.println("Estado: " + datum.getStatus());
                    System.out.println("Fecha de inicio: " + datum.getStart_date());
                    System.out.println("Fecha de fin: " + datum.getEnd_date());
                    System.out.println("Tipo de contrato: " + datum.getContract_type());
                    System.out.println("Contribución total: " + datum.getTotal_contribution());
                    ArrayList<ByMonth> byMonthList = datum.getBy_month();
                    if (byMonthList != null) {
                        for (ByMonth byMonth : byMonthList) {
                            System.out.println("Período: " + byMonth.getPeriod());
                            System.out.println("Monto gravable: " + byMonth.getTaxable_amount());
                            System.out.println("Cotizado: " + byMonth.getQuoted());
                            System.out.println("Fecha de pago: " + byMonth.getPayment_date());
                            System.out.println();
                        }
                    }
                    System.out.println("--------------------");
                }
            }
        } else {
            // La solicitud no fue exitosa, imprimir el código de respuesta HTTP
            System.out.println("La solicitud falló. Código de respuesta: " + statusCode);
        }
	}

}
