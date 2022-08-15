package com.example.urlss.controller;

import com.example.urlss.entity.URLWrapper;
import com.example.urlss.service.ShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("*")
public class ShorteningController {

    @Autowired
    private ShorteningService shorteningService;

    @PostMapping("/encode")
    public ResponseEntity<URLWrapper> encodeLink(@RequestBody URLWrapper requestedURLWrapper) {
        return ResponseEntity.ok(shorteningService.encodeURL(requestedURLWrapper));
    }

    @PostMapping("/decode")
    public ResponseEntity<URLWrapper> decodeLink(@RequestBody URLWrapper requestedURLWrapper) {
        return ResponseEntity.ok(shorteningService.decodeURL(requestedURLWrapper));
    }
}
