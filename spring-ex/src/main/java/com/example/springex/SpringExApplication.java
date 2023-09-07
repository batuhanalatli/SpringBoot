package com.example.springex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringExApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExApplication.class, args);
    }

}
