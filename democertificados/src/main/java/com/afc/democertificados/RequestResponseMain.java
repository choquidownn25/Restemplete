/**
 * 
 */
package com.afc.democertificados;
import com.afc.democertificados.models.ByMonth;
import com.afc.democertificados.models.Datum;
import com.afc.democertificados.models.DetalleAportantes;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Madre Hermosa
 *
 */
public class RequestResponseMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token = "your_bearer_token";
        String url = "https://api.floid.app/cl/banco_bci_personas/products";
        String requestBody = "{\"id\":\"11111111-1\",\"password\":\"password123\", \"sandbox\":\"true\"}";

        HttpResponse<String> response = Unirest.post(url)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .asString();

        if (response.isSuccess()) {
            String responseBody = response.getBody();
            DetalleAportantes detalleAportantes = mapResponse(responseBody);
            printDetalleAportantes(detalleAportantes);
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getStatusText());
        }
       
	}
	
	private static DetalleAportantes mapResponse(String responseBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, DetalleAportantes.class);
        } catch (IOException e) {
            System.out.println("Error mapping response: " + e.getMessage());
            return null;
        }
    }

    private static void printDetalleAportantes(DetalleAportantes detalleAportantes) {
        if (detalleAportantes != null) {
            System.out.println("Code: " + detalleAportantes.getCode());
            System.out.println("Message: " + detalleAportantes.getMsg());
            System.out.println("Case ID: " + detalleAportantes.getCaseid());

            if (detalleAportantes.getData() != null) {
                for (Datum datum : detalleAportantes.getData()) {
                    System.out.println("RUT Employer: " + datum.getRut_employer());
                    System.out.println("Company Name: " + datum.getCompany_name());
                    System.out.println("Status: " + datum.getStatus());
                    System.out.println("Start Date: " + datum.getStart_date());
                    System.out.println("End Date: " + datum.getEnd_date());
                    System.out.println("Contract Type: " + datum.getContract_type());
                    System.out.println("Total Contribution: " + datum.getTotal_contribution());

                    if (datum.getBy_month() != null) {
                        for (ByMonth byMonth : datum.getBy_month()) {
                            System.out.println("Period: " + byMonth.getPeriod());
                            System.out.println("Taxable Amount: " + byMonth.getTaxable_amount());
                            System.out.println("Quoted: " + byMonth.getQuoted());
                            System.out.println("Payment Date: " + byMonth.getPayment_date());
                            System.out.println("------------------------");
                        }
                    }

                    System.out.println("========================");
                }
            }
        }
    }

}
