/**
 * 
 */
package com.afc.democertificados;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.afc.democertificados.models.DetalleAportantes;
import com.google.gson.Gson;
/**
 * @author Madre Hermosa
 *
 */
public class MainBarerToken {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		  URL url = new URL("https://api.floid.app/cl/afc/detalle_aportantes");
		// Crear la conexión HTTP
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0");
        connection.setDoOutput(true);

        // Construir el cuerpo de la solicitud
        String requestBody = "{ \"id\": \"11111111-1\", \"password\": \"1234\", \"sandbox\": \"true\" }";

        // Enviar la solicitud POST
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            outputStream.write(input, 0, input.length);
        }

        // Leer la respuesta del servidor
        int responseCode = connection.getResponseCode();
        BufferedReader reader;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Mapear la respuesta a la clase DetalleAportantes
        DetalleAportantes detalleAportantes = new DetalleAportantes();
        // Asumiendo que la respuesta es un JSON con los campos code, msg, caseid y data
        // Utiliza una biblioteca de JSON como Jackson o Gson para hacer el mapeo
        // Aquí se muestra un ejemplo utilizando Gson:
        Gson gson = new Gson();
        detalleAportantes = gson.fromJson(response.toString(), DetalleAportantes.class);

        // Acceder a los datos mapeados
        System.out.println("Code: " + detalleAportantes.getCode());
        System.out.println("Msg: " + detalleAportantes.getMsg());
        System.out.println("Case ID: " + detalleAportantes.getCaseid());
	}

}
