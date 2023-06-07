/**
 * 
 */
package com.afc.democertificados;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import com.afc.democertificados.models.CertificadoBeneficios;
import com.afc.democertificados.models.Datum;
import com.afc.democertificados.models.Periodo;
import com.google.gson.Gson;

/**
 * @author Madre Hermosa
 *
 */
public class CertificadoBeneficiosApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
				String url  = "https://api.floid.app/cl/afc/get_certificado_beneficios";
		        String bearerToken = "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0";
		        String requestPayload = "{ \"id\": \"11111111-1\", \"password\": \"1234\", \"sandbox\": \"true\" }";
		     // Establecer la conexión
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
		        CertificadoBeneficios certificadoBeneficios = gson.fromJson(response, CertificadoBeneficios.class);
		        System.out.println("Estado del servicio Numero: " + certificadoBeneficios.getCode());
		        System.out.println("Estado del servicio Nombre : " + certificadoBeneficios.getMsg());
		        System.out.println("Estado del servicio Mensaje: " + certificadoBeneficios.getCaseid());
		        // Imprimir los datos
		        for (Periodo datum : certificadoBeneficios.getData()) {
		        	System.out.println("---------------------------------------------------------" );
		        	System.out.println("Fecha Solicitud : " + datum.getFecha_sol());
		        	
		        	
		            System.out.println("N° Solicitud: " + datum.getN_sol());
		            System.out.println("Nombre de la empresa: " + datum.getNombre_emp());
		            System.out.println("Tipo de Solicitud: " + datum.getTipo_sol());
		            System.out.println("Fecha Finiquito: " + datum.getFecha_finiquito());
		            System.out.println("Fecha Último Giro: " + datum.getFecha_ult_giro());
		            System.out.println("Giros Pagados: " + datum.getGiros_pagados());
		            System.out.println("Financiamiento CIC: " + datum.getcIC());
		            System.out.println("Financiamiento FCS: " + datum.getfCS());
		            System.out.println("Totales pagados: " + datum.getTotales_pagados());
	
		        }
		      
		      
	}

}
