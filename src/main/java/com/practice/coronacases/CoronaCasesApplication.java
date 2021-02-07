package com.practice.coronacases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaCasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoronaCasesApplication.class, args);
    }

}
