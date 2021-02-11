package com.smart.home.lara;

import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.repository.FeatureInMemoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeatureRepositoryAdapter implements FeatureRepository {

  private final FeatureInMemoryRepository featureInMemoryRepository;

  @Override
  public Flux<Feature> findAllByRoom(UUID roomId) {
    return featureInMemoryRepository.findAllByRoom(roomId);
  }

  @Override
  public Mono<FeatureData> findLatestDataForFeature(UUID featureId) {
    return featureInMemoryRepository.findLatestDataForFeature(featureId);
  }

  @Override
  public Mono<FeatureData> recordData(FeatureData featureData) {
    return featureInMemoryRepository.recordData(featureData);
  }
}
