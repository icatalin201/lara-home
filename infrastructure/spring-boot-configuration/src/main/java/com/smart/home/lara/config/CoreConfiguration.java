package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.primary.impl.LaraPortImpl;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
public class CoreConfiguration {

  @Bean
  public LaraPort laraPort(RoomRepository roomRepository, FeatureRepository featureRepository) {
    return new LaraPortImpl(roomRepository, featureRepository);
  }
}
