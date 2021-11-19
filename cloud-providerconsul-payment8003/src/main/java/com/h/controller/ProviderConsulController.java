package com.h.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderConsulController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/provider")
    public String provider(){
        System.out.println(1);
        return port+ UUID.randomUUID().toString();
    }
}
