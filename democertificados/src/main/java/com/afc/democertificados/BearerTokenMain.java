/**
 * 
 */
package com.afc.democertificados;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.OutputStream;

import com.afc.democertificados.models.ByMonth;
import com.afc.democertificados.models.Datum;
import com.afc.democertificados.models.DetalleAportantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;


import com.google.gson.Gson;
/**
 * @author Madre Hermosa
 *
 */
public class BearerTokenMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url  = "https://api.floid.app/cl/afc/detalle_aportantes";
        String bearerToken = "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0";
        String requestPayload = "{ \"id\": \"11111111-1\", \"password\": \"1234\", \"sandbox\": \"true\" }";
     // Establecer la conexión
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Enviar la solicitud
        connection.getOutputStream().write(requestPayload.getBytes("UTF-8"));
        connection.getOutputStream().flush();
        connection.getOutputStream().close();

        // Obtener la respuesta
        int responseCode = connection.getResponseCode();
        String response = "";
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = reader.lines().collect(Collectors.joining());
            reader.close();
        } else {
            System.out.println("Error en la respuesta: " + responseCode);
        }

        // Mapear la respuesta a las clases
        Gson gson = new Gson();
        DetalleAportantes detalleAportantes = gson.fromJson(response, DetalleAportantes.class);
        System.out.println("Estado del servicio Numero: " + detalleAportantes.getCode());
        System.out.println("Estado del servicio Nombre : " + detalleAportantes.getMsg());
        System.out.println("Estado del servicio Mensaje: " + detalleAportantes.getCaseid());
      
        // Imprimir los datos
        for (Datum datum : detalleAportantes.getData()) {
        	System.out.println("---------------------------------------------------------" );
        	System.out.println("Estado del servicio : " + datum.getStatus());
        	
        	
            System.out.println("RUT del empleador: " + datum.getRut_employer());
            System.out.println("Nombre de la empresa: " + datum.getCompany_name());
            System.out.println("Estado: " + datum.getStatus());
            System.out.println("Fecha de inicio: " + datum.getStart_date());
            System.out.println("Fecha de fin: " + datum.getEnd_date());
            System.out.println("Tipo de contrato: " + datum.getContract_type());
            System.out.println("Contribución total: " + datum.getTotal_contribution());
            System.out.println("Datos por mes:");
            for (ByMonth byMonth : datum.getBy_month()) {
                System.out.println("  Período: " + byMonth.getPeriod());
                System.out.println("  Monto gravable: " + byMonth.getTaxable_amount());
                System.out.println("  Cotizado: " + byMonth.getQuoted());
                System.out.println("  Fecha de pago: " + byMonth.getPayment_date());
                System.out.println();
            }
        }
        
	}
	
	
}
