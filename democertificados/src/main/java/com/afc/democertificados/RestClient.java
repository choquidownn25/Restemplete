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
public class RestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://api.floid.app/cl/afc/detalle_aportantes";
        String bearerToken = "3c6e1b8f8dbdc4d883068bdd945f216ab2df9dae83950503ad849d2e720f3a9a48feabf4be8ad76f93a1d33d33ad910fc734fd60963f6aaeb5776fa74aaaf1d0";
        String requestBody = "{ \"id\": \"11111111-1\", \"password\": \"1234\", \"sandbox\": \"true\" }";

        try {
            // Crear la conexión
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviar el cuerpo de la petición
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();
            BufferedReader reader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            // Leer la respuesta
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
               
            }
            reader.close();

            // Mapear la respuesta a la clase DetalleAportantes
            DetalleAportantes detalleAportantes = new DetalleAportantes();
            // Asumiendo que la respuesta es un JSON con los mismos campos que la clase DetalleAportantes
            detalleAportantes = new Gson().fromJson(response.toString(), DetalleAportantes.class);

            // Utilizar los datos mapeados
            System.out.println("Code: " + detalleAportantes.getCode());
            System.out.println("Msg: " + detalleAportantes.getMsg());
            System.out.println("Case ID: " + detalleAportantes.getCaseid());

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
