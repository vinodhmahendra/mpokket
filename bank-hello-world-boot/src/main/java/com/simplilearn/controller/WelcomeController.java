package com.simplilearn.controller;

import com.simplilearn.model.Welcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @GetMapping("/")
    public String helloWorld() {
        logger.warn("this is warning message");
        return "Hello World!";
    }

    @GetMapping("/welcome")
    public Welcome helloWelcome() {

        return new Welcome("Hello World! object");
    }
}
