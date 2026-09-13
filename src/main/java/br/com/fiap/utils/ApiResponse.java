package br.com.fiap.utils;

import br.com.fiap.entities.Client;
import br.com.fiap.entities.User;

import java.util.ArrayList;

public class ApiResponse {
    public static String loginSuccess(User user) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Login realizado com sucesso\",\n" +
                "  \"user\": {\n" +
                "    \"id\": " + user.getUserId() + ",\n" +
                "    \"name\": \"" + user.getUserName() + "\"\n" +
                "  }\n" +
                "}";
    }

    public static String registerSuccess(int id) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Usuario cadastrado com sucesso\",\n" +
                "  \"userId\": " + id + "\n" +
                "}";
    }

    public static String error(String message) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": false,\n" +
                "  \"error\": \"" + message + "\"\n" +
                "}";
    }

    public static String clientCreateSuccess(int id) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Cliente cadastrado com sucesso\",\n" +
                "  \"clientId\": " + id + "\n" +
                "}";
    }

    public static String clientFoundSuccess(Client client) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"client\": {\n" +
                "    \"id\": " + client.getClientId() + ",\n" +
                "    \"name\": \"" + client.getName() + "\",\n" +
                "    \"email\": \"" + client.getEmail() + "\",\n" +
                "    \"phone\": \"" + client.getPhone() + "\",\n" +
                "    \"role\": \"" + client.getRole() + "\",\n" +
                "    \"department\": \"" + client.getDepartment() + "\"\n" +
                "  }\n" +
                "}";
    }

    public static String clientListSuccess(ArrayList<Client> clients) {
        String json = "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"clients\": [\n";

        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);

            json += "    {\n" +
                    "      \"id\": " + client.getClientId() + ",\n" +
                    "      \"name\": \"" + client.getName() + "\",\n" +
                    "      \"email\": \"" + client.getEmail() + "\",\n" +
                    "      \"phone\": \"" + client.getPhone() + "\",\n" +
                    "      \"role\": \"" + client.getRole() + "\",\n" +
                    "      \"department\": \"" + client.getDepartment() + "\"\n" +
                    "    }";

            if (i < clients.size() - 1) {
                json += ",";
            }

            json += "\n";
        }

        json += "  ]\n" +
                "}";

        return json;
    }

    public static String clientUpdateSuccess() {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Cliente atualizado com sucesso\"\n" +
                "}";
    }

    public static String clientDeleteSuccess() {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Cliente excluido com sucesso\"\n" +
                "}";
    }

}
