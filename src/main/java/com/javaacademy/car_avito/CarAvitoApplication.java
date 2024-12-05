package com.javaacademy.car_avito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarAvitoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CarAvitoApplication.class, args);
    }
}
