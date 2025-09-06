package com.nakarmi.mcq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class McqApplication {

    public static void main(String[] args) {
        SpringApplication.run(McqApplication.class, args);
    }

}
