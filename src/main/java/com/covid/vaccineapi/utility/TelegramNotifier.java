package com.covid.vaccineapi.utility;

import javax.ws.rs.core.UriBuilder;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TelegramNotifier {

    private static final String CHAT_ID = "1207211261";
    private static final String TOKEN = "1804894879:AAHvreci_5gqXPrWmA7r2QNCZTa0jua_-sw";

    public static void main(String[] args) throws IOException, InterruptedException {

        String message = "Hello World from Java 11";

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();

        UriBuilder builder = UriBuilder
                .fromUri("https://api.telegram.org")
                .path("/{token}/sendMessage")
                .queryParam("chat_id", CHAT_ID)
                .queryParam("text", message);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(builder.build("bot" + TOKEN))
                .timeout(Duration.ofSeconds(5))
                .build();

        System.out.println("req > "+request.uri());
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}