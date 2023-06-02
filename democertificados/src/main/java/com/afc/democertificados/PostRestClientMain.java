/**
 * 
 */
package com.afc.democertificados;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.afc.democertificados.models.Post;
import com.google.gson.Gson;
/**
 * @author Madre Hermosa
 *
 */
public class PostRestClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // URL de la API REST
            String url = "https://jsonplaceholder.typicode.com/posts";
            
            // Realizar la solicitud GET a la URL
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            
            // Obtener la respuesta de la API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                // Mapear el resultado a la clase Post utilizando Gson
                Gson gson = new Gson();
                Post[] posts = gson.fromJson(response.toString(), Post[].class);
                
                // Hacer uso de los datos mapeados
                for (Post post : posts) {
                    System.out.println("ID: " + post.getId());
                    System.out.println("UserID: " + post.getUserId());
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Body: " + post.getBody());
                    System.out.println("-------------------------");
                }
            } else {
                System.out.println("Error en la respuesta de la API. Código de respuesta: " + responseCode);
            }
            
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
