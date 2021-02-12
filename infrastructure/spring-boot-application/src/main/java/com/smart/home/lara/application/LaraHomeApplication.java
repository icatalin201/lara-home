package com.smart.home.lara.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** lara Created by Catalin on 2/11/2021 */
@SpringBootApplication(scanBasePackages = "com.smart.home.lara.config")
public class LaraHomeApplication {

  public static void main(String[] args) {
    SpringApplication.run(LaraHomeApplication.class, args);
  }
}
