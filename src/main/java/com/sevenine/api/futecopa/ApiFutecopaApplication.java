package com.sevenine.api.futecopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiFutecopaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFutecopaApplication.class, args);
    }

}
