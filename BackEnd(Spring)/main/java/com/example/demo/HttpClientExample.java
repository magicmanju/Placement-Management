package com.example.demo;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Define the URL of your Spring Boot application
            URL url = new URL("http://localhost:8085/registercollege");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Define the request body as a JSON string
            String requestBody = "{\"id\": 1, \"name\": \"Example College\", \"admin\": \"Admin Name\", \"location\": \"College Location\"}";

            // Write the request body to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                System.out.println("College registered successfully");
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
