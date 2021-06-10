package com.training.springboot.productmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ProductmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductmanagerApplication.class, args);
    }

}
