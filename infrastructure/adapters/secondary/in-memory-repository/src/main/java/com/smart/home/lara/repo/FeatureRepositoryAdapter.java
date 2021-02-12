package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.repo.repository.LaraInMemoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeatureRepositoryAdapter implements FeatureRepository {

  private final LaraInMemoryRepository repository;

  @Override
  public Mono<Feature> create(Feature feature) {
    return repository.createFeature(feature);
  }

  @Override
  public Mono<Feature> findById(UUID id) {
    return repository.findFeatureById(id);
  }

  @Override
  public Flux<Feature> findAllByRoom(UUID roomId) {
    return repository.findAllFeaturesByRoom(roomId);
  }

  @Override
  public Flux<FeatureData> findAllDataByFeature(UUID featureId) {
    return repository.findAllDataByFeature(featureId);
  }

  @Override
  public Mono<FeatureData> recordData(FeatureData featureData) {
    return repository.recordData(featureData);
  }
}
