package com.h;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EureakMain {
    public static void main(String[] args) {
        System.out.println(2);
        SpringApplication.run(EureakMain.class,args);
    }
}
