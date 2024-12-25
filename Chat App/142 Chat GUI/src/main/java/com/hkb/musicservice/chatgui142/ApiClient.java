package com.hkb.musicservice.chatgui142;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class ApiClient {

    public static void main(String[] args) {
        try {
            List<String> messages = new ApiClient().fetchMessages();
            for (String message : messages) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> fetchMessages() throws IOException {
        List<String> list = new LinkedList<>();
        URL url = new URL("http://localhost:8080/api/message/getAll");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("URL Not Accepted, Response Code: " + responseCode);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Model>>() {}.getType();
            List<Model> modelList = gson.fromJson(result.toString(), listType);

            for (Model model : modelList) {
                StringBuilder text = new StringBuilder();
                text.append(model.getAuthor());
                text.append(" : ");
                text.append(model.getMessage());
                list.add(text.toString());
            }
        }

        return list;
    }
}