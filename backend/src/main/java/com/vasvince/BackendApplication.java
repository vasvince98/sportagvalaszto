package com.vasvince;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        System.out.println("This is a pull request test");
        SpringApplication.run(BackendApplication.class, args);
    }

}
