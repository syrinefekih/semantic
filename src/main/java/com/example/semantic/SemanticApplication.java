package com.example.semantic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SemanticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SemanticApplication.class, args);
        try {
            String userInput = "I want to visit paris and London and Tunisia";
            String spotlightResponse = SpotlightEntityRecognition.recognizeEntities(userInput);
            System.out.println("DBpedia Spotlight Response: " + spotlightResponse);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
