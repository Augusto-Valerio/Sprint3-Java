package br.com.fiap.utils;

import br.com.fiap.entities.Client;
import br.com.fiap.entities.Transcription;
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
                "    \"name\": \"" + user.getUserName() + "\",\n" +
                "    \"email\": \"" + user.getUserEmail() + "\",\n" +
                "    \"type\": \"" + user.getUserType() + "\"\n" +
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

    public static String clientAreaSuccess() {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Area do cliente acessada com sucesso\"\n" +
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

    public static String transcriptionCreateSuccess(int id) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Transcrição cadastrada com sucesso\",\n" +
                "  \"transcriptionId\": " + id + "\n" +
                "}";
    }

    public static String transcriptionFoundSuccess(Transcription transcription) {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"transcription\": {\n" +
                "    \"id\": " + transcription.getTranscriptionId() + ",\n" +
                "    \"meetingId\": " + transcription.getMeetingId() + ",\n" +
                "    \"content\": \"" + transcription.getContent() + "\",\n" +
                "    \"processingStatus\": \"" + transcription.getProcessingStatus() + "\"\n" +
                "  }\n" +
                "}";
    }

    public static String transcriptionListSuccess(ArrayList<Transcription> transcriptions) {
        String json = "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"transcriptions\": [\n";

        for (int i = 0; i < transcriptions.size(); i++) {
            Transcription transcription = transcriptions.get(i);

            json += "    {\n" +
                    "      \"id\": " + transcription.getTranscriptionId() + ",\n" +
                    "      \"meetingId\": " + transcription.getMeetingId() + ",\n" +
                    "      \"content\": \"" + transcription.getContent() + "\",\n" +
                    "      \"processingStatus\": \"" + transcription.getProcessingStatus() + "\"\n" +
                    "    }";

            if (i < transcriptions.size() - 1) {
                json += ",";
            }

            json += "\n";
        }

        json += "  ]\n" +
                "}";

        return json;
    }

    public static String transcriptionUpdateSuccess() {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Transcrição atualizada com sucesso\"\n" +
                "}";
    }

    public static String transcriptionDeleteSuccess() {
        return "Resultado Api TOTVS:\n" +
                "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Transcrição excluída com sucesso\"\n" +
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
