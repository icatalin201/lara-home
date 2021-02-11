package com.smart.home.lara.core.application.port.primary;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface FeaturePort {
  Mono<Feature> create(Feature feature);

  Mono<FeatureData> recordData(FeatureData featureData);

  Flux<Feature> findAllByRoom(UUID roomId);
}
