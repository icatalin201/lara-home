package com.smart.home.lara.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
@Import({
  CoreConfiguration.class,
  MessagingConfiguration.class,
  RepositoryConfiguration.class,
  RestConfiguration.class,
  SecurityConfiguration.class,
  TestDataConfiguration.class
})
public class LaraConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
