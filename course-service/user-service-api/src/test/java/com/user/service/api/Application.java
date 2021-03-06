package com.user.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = { "com.user.service.api" })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
