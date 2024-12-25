package com.hkb.musicservice.chatgui142;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable, Runnable {

    @FXML
    public TextField message;

    @FXML
    public ListView<String> list;

    private String name;

    private Thread t1 = new Thread(this);

    @FXML
    public void onSendMessage(ActionEvent event) throws IOException {
        // Kullanıcı mesajını al
        String userMessage = message.getText();

        // Mesaj boş değilse listeye ekle
        if (userMessage != null && !userMessage.trim().isEmpty()) {

            send(name, userMessage);
            // Mesaj alanını temizle
            message.clear();

            // Listeyi otomatik olarak en alta kaydır
            list.scrollTo(list.getItems().size() - 1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t1.start();
        while (true) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Enter your name");
            dialog.setContentText("Please Enter Your Name :");
            dialog.setHeaderText("Enter name");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                result.ifPresent(s -> name = s);
                break;
            }
        }
    }



    private List<String> messages() throws IOException {
        List<String> list = new LinkedList<>();
        URL url = new URL("http://localhost:8080/api/message/getAll");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type","application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        if(responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("URL Not Accepted Post Code :" + responseCode);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder result = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Model>>() {}.getType();
        List<Model> Listmodel = gson.fromJson(result.toString(), listType);
        for (Model model :
             Listmodel) {
            StringBuilder text = new StringBuilder();
            text.append(model.getAuthor());
            text.append(" : ");
            text.append(model.getMessage());
            list.add(text.toString());
        }
        return list;
    }

    @Override
    public void run() {
        while (true) {
            // İşlemler
            try {
                Platform.runLater(() -> {
                    try {
                        list.setItems(FXCollections.observableList(messages()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                Thread.sleep(400);
            } catch (InterruptedException ex) {
                ex.fillInStackTrace();
            }
        }
    }

    public void send(String author, String msg) throws IOException {
        URL url = new URL("http://localhost:8080/api/message/send");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        // JSON verisini oluştur
        Map<String, String> messageData = new HashMap<>();
        messageData.put("author", author);
        messageData.put("message", msg);
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(messageData);

        // JSON verisini gönder
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Yanıt kodunu kontrol et
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP POST Request Failed with Error code : " + responseCode);
        }
    }
}
/*
 */