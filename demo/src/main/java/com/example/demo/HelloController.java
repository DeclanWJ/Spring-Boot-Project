package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Web request handler
// Combines @Controller and @ResponseBody
// Returns data rather than a view : AKA HTML based web page
@RestController
public class HelloController {

    // Index mapping for requests aka: URL/
    @GetMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }

}