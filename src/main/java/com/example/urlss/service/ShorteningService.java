package com.example.urlss.service;

import com.example.urlss.entity.URLWrapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;

@Service
public class ShorteningService {

    private static final String BASE_URL = "http://localhost:8080/";

    private final HashMap<String, String> encodedDecodedUrlMap = new HashMap<>();

    public URLWrapper encodeURL(URLWrapper originalURLWrapper) {
        String originalURL = originalURLWrapper.getUrl();
        String encodedUrl = generateEncodedURL(originalURL);
        encodedDecodedUrlMap.put(encodedUrl, originalURL);
        return new URLWrapper(encodedUrl);
    }

    public URLWrapper decodeURL(URLWrapper requestedURL) {
        return new URLWrapper(encodedDecodedUrlMap.get(requestedURL.getUrl()));
    }

    private String generateEncodedURL(String requestedURL) {
        String originalUrlHashCode = String.valueOf(requestedURL.hashCode());
        String encodedOriginaUrl = Base64.getUrlEncoder().encodeToString(originalUrlHashCode.getBytes());
        return BASE_URL + encodedOriginaUrl;
    }
}
