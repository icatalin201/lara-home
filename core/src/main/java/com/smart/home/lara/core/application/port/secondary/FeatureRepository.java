package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface FeatureRepository {
  Mono<Feature> create(Feature feature);

  Mono<Feature> findById(UUID id);

  Flux<Feature> findAllByRoom(UUID roomId);

  Flux<FeatureData> findAllDataByFeature(UUID featureId);

  Mono<FeatureData> recordData(FeatureData featureData);
}
