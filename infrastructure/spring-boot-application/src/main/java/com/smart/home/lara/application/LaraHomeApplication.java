package com.smart.home.lara.application;

import com.smart.home.lara.config.LaraConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/** lara Created by Catalin on 2/11/2021 */
@Import(LaraConfiguration.class)
@SpringBootApplication
public class LaraHomeApplication {

  public static void main(String[] args) {
    SpringApplication.run(LaraHomeApplication.class, args);
  }
}
