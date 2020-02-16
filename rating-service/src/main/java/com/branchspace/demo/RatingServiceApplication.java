package com.branchspace.demo;

import com.branchspace.demo.configuration.DbInitializer;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class RatingServiceApplication {

    private final DbInitializer dbInitializer;

    @PostConstruct
    public void initializeDatabase() {
        dbInitializer.initDatabase();
    }

    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }

}
