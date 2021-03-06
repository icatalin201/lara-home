package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.messaging.MessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/14/2021 */
@Configuration
@ComponentScan(basePackages = "com.smart.home.lara.messaging")
public class MessagingAdapterConfig {

  @Bean
  public MessageListener messageListener(FeatureDataPort featureDataPort) {
    return new MessageListener(featureDataPort);
  }
}
