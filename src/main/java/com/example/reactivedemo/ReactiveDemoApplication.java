package com.example.reactivedemo;

import com.example.reactivedemo.entities.StudentRequest;
import com.example.reactivedemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class,
                              args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService service) {
        return args -> {
            for (int i = 0; i <= 100; i++) {
                service.save(StudentRequest.builder()
                                           .firstName("Ahmed ")
                                           .lastName("Ali " + i)
                                           .age(i)
                                           .build())
                       .subscribe();
            }
        };
    }

}
