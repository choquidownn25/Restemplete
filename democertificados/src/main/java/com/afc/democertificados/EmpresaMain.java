package com.afc.democertificados;

import java.util.List;

import com.afc.democertificados.models.Empresa;
import com.afc.democertificados.models.InfoEmpresa;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmpresaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "{\n" +
                "    \"codigo\": \"1\",\n" +
                "    \"estatus\": \"OK\",\n" +
                "    \"infoEmpresas\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"dni\": \"99551740K\",\n" +
                "            \"razonSocial\": \"E-Sign S.A.\",\n" +
                "            \"fechaCreacion\": \"28/06/2023 04:28:43\",\n" +
                "            \"estado\": \"HABILITADA\",\n" +
                "            \"usuarios\": null,\n" +
                "            \"sistemas\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"dni\": \"11111111-1\",\n" +
                "            \"razonSocial\": \"Prueba-Floid\",\n" +
                "            \"fechaCreacion\": \"28/06/2023 04:28:43\",\n" +
                "            \"estado\": \"HABILITADA\",\n" +
                "            \"usuarios\": null,\n" +
                "            \"sistemas\": null\n" +
                "        }\n" +
                "    ],\n" +
                "    \"comentario\": \"Información de empresas obtenida con éxito\"\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Empresa empresa = objectMapper.readValue(json, Empresa.class);

            // Haz lo que necesites con la instancia de la clase Empresa
            System.out.println("Código: " + empresa.getCodigo());
            System.out.println("Estatus: " + empresa.getEstatus());
            System.out.println("Comentario: " + empresa.getComentario());

            List<InfoEmpresa> infoEmpresas = empresa.getInfoEmpresas();
            for (InfoEmpresa infoEmpresa : infoEmpresas) {
                System.out.println("ID: " + infoEmpresa.getId());
                System.out.println("DNI: " + infoEmpresa.getDni());
                System.out.println("Razón Social: " + infoEmpresa.getRazonSocial());
                // Continúa con los demás campos de InfoEmpresa
                System.out.println("------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
