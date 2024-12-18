package rs.aqerd.shared;

import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import rs.aqerd.Requests;

import java.util.HashMap;
import java.util.Map;

import static rs.aqerd.shared.Environment.*;

public class HttpConfiguration {
    public static Requests client = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new FormEncoder())
            .decoder(new JacksonDecoder())
            .target(Requests.class, getSpotifyUrl());

    public static void createHttpData() {
        Map<String, String> form = new HashMap<>();
        form.put("grant_type", "client_credentials");
        form.put("client_id", getSpotifyClientId());
        form.put("client_secret", getSpotifyClientSecret());

        try {
            String response = client.getToken(form).toString();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
