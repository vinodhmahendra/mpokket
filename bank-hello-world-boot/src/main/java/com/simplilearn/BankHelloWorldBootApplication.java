package com.simplilearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BankHelloWorldBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankHelloWorldBootApplication.class, args);
    }

}
