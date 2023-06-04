/**
 * 
 */
package com.afc.democertificados;
import com.afc.democertificados.models.ByMonth;
import com.afc.democertificados.models.Datum;
import com.afc.democertificados.models.DetalleAportantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Madre Hermosa
 *
 */
public class MainToken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Datos de la solicitud POST
        String requestUrl = "https://api.floid.app/cl/afc/detalle_aportantes";
        String bearerToken  = "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0";
        String requestBody = "{\"id\": \"11111111-1\", \"password\": \"1234\", \"sandbox\": \"true\"}";

        try {
            // Crear la conexión HTTP
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviar la solicitud POST
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Procesar la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Mapear el resultado en las clases proporcionadas
                DetalleAportantes detalleAportantes = parseResponse(response.toString());

                // Imprimir el resultado
                System.out.println("Code: " + detalleAportantes.getCode());
                System.out.println("Msg: " + detalleAportantes.getMsg());
                System.out.println("Case ID: " + detalleAportantes.getCaseid());

                ArrayList<Datum> data = detalleAportantes.getData();
                if (data != null) {
                    for (Datum datum : data) {
                    	System.out.println("---------------------------------------------------------" );
                        System.out.println("RUT Employer: " + datum.getRut_employer());
                        System.out.println("Company Name: " + datum.getCompany_name());
                        // Imprimir otros campos de interés...
                        System.out.println("Estado: " + datum.getStatus());
                        System.out.println("Fecha de inicio: " + datum.getStart_date());
                        System.out.println("Fecha de fin: " + datum.getEnd_date());
                        System.out.println("Tipo de contrato: " + datum.getContract_type());
                        System.out.println("Contribución total: " + datum.getTotal_contribution());
                        System.out.println("Datos por mes:");
                        for (ByMonth byMonth : datum.getBy_month()) {
                        	System.out.println("{" );
                            System.out.println("  Período: " + byMonth.getPeriod());
                            System.out.println("  Monto gravable: " + byMonth.getTaxable_amount());
                            System.out.println("  Cotizado: " + byMonth.getQuoted());
                            System.out.println("  Fecha de pago: " + byMonth.getPayment_date());
                            System.out.println();
                            System.out.println("}" );
                        }
                    }
                } else {
                    System.out.println("Data is null");
                }
            } else {
                System.out.println("HTTP Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static DetalleAportantes parseResponse(String response) {
        // Utilizar una biblioteca de JSON parsing como Gson o Jackson para mapear la respuesta JSON a las clases Java
        // Aquí se proporciona un ejemplo utilizando la biblioteca Gson de Google

        // Asegúrate de agregar la biblioteca Gson a tu proyecto
        // Maven: com.google.code.gson:gson:2.8.8

        com.google.gson.Gson gson = new com.google.gson.Gson();
        return gson.fromJson(response, DetalleAportantes.class);
    }
}
