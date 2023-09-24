package com.elyashevich.reddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableMongoAuditing
public class StartApplication{

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
