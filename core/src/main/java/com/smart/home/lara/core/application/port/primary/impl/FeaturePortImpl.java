package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeaturePortImpl implements FeaturePort {

  private final FeatureRepository featureRepository;

  @Override
  public Flux<Feature> findAllByRoom(UUID roomId) {
    return featureRepository.findAllByRoom(roomId);
  }

  @Override
  public Mono<FeatureData> findLatestDataForFeature(UUID featureId) {
    return featureRepository.findLatestDataForFeature(featureId);
  }

  @Override
  public Mono<FeatureData> recordData(FeatureData featureData) {
    return featureRepository.recordData(featureData);
  }
}
