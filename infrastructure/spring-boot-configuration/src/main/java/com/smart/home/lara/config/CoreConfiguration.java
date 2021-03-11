package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.service.FeatureDataService;
import com.smart.home.lara.core.domain.service.FeatureService;
import com.smart.home.lara.core.domain.service.RoomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
public class CoreConfiguration {

  @Bean
  public RoomPort laraPort(RoomRepository roomRepository) {
    return new RoomService(roomRepository);
  }

  @Bean
  public FeaturePort featurePort(FeatureRepository featureRepository, RoomPort roomPort) {
    return new FeatureService(featureRepository, roomPort);
  }

  @Bean
  public FeatureDataPort featureDataPort(FeatureRepository featureRepository) {
    return new FeatureDataService(featureRepository);
  }
}
