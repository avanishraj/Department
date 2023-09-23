package com.avanish.main.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;
//    @RequestMapping(value = "/avanish", method = RequestMethod.GET)
    @GetMapping("/avanish")
    public String hello(){
        return welcomeMessage;
    }
}
