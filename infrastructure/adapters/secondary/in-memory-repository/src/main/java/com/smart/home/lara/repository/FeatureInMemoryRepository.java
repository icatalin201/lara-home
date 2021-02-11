package com.smart.home.lara.repository;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public class FeatureInMemoryRepository {

  private final List<Feature> features = new ArrayList<>();

  public Flux<Feature> findAllByRoom(UUID roomId) {
    return null;
  }

  public Mono<FeatureData> findLatestDataForFeature(UUID featureId) {
    return null;
  }

  public Mono<FeatureData> recordData(FeatureData featureData) {
    return null;
  }
}
