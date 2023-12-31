package com.example.semantic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/semantic")
class SemanticController {

    @PostMapping("/processInput")
    public String processInput(@RequestBody String input) {
        try {
            String spotlightResponse = SpotlightEntityRecognition.recognizeEntities(input);
            return spotlightResponse;
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}