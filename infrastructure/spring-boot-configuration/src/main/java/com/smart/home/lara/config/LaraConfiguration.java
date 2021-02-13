package com.smart.home.lara.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
@ComponentScan(basePackages = "com.smart.home.lara.messaging")
public class LaraConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
