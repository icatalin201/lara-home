package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.service.FeatureDataService;
import com.smart.home.lara.core.domain.service.LaraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
public class CoreConfiguration {

  @Bean
  public LaraPort laraPort(RoomRepository roomRepository, FeatureRepository featureRepository) {
    return new LaraService(roomRepository, featureRepository);
  }

  @Bean
  public FeatureDataPort featureDataPort(FeatureRepository featureRepository) {
    return new FeatureDataService(featureRepository);
  }
}
