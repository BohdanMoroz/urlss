package com.example.urlss.service;

import com.example.urlss.entity.URLWrapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShorteningServiceTest {

    static final String ORIGINAL_GOOGLE_URL = "https://www.google.com";
    static final String ORIGINAL_BING_URL = "https://www.bing.com";

    @Autowired
    ShorteningService shorteningService;

    @Test
    void testSequentialEncodingAndDecoding() {
        String encodedGoogleURL = shorteningService.encodeURL(new URLWrapper(ORIGINAL_GOOGLE_URL)).getUrl();
        String encodedBingURL = shorteningService.encodeURL(new URLWrapper(ORIGINAL_BING_URL)).getUrl();

        String decodedGoogleURL = shorteningService.decodeURL(new URLWrapper(encodedGoogleURL)).getUrl();
        String decodedBingURL = shorteningService.decodeURL(new URLWrapper(encodedBingURL)).getUrl();

        Assert.assertEquals(ORIGINAL_GOOGLE_URL, decodedGoogleURL);
        Assert.assertEquals(ORIGINAL_BING_URL, decodedBingURL);
    }
}