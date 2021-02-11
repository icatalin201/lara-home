package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeaturePortImpl implements FeaturePort {

  private final FeatureRepository featureRepository;

  @Override
  public Mono<Feature> create(Feature feature) {
    Feature createdFeature = featureRepository.create(feature);
    return Mono.just(createdFeature);
  }

  @Override
  public Mono<FeatureData> recordData(FeatureData featureData) {
    FeatureData createdFeatureData = featureRepository.recordData(featureData);
    return Mono.just(createdFeatureData);
  }

  @Override
  public Flux<Feature> findAllByRoom(UUID roomId) {
    List<Feature> features = featureRepository.findAllByRoom(roomId);
    features.forEach(this::setLastFeatureData);
    return Flux.fromIterable(features);
  }

  private void setLastFeatureData(Feature feature) {
    Optional<FeatureData> optionalFeatureData =
        featureRepository.findAllDataByFeature(feature.getId()).stream()
            .sorted(Comparator.comparing(FeatureData::getRecordedOn).reversed())
            .findFirst();
    optionalFeatureData.ifPresent(feature::setLastRecordedData);
  }
}
