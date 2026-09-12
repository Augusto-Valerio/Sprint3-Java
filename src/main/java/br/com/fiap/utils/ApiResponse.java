package br.com.fiap.utils;

import br.com.fiap.entities.User;

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
}
