package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.FeatureData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface FeatureRepository {
  void create(Feature feature);

  Optional<Feature> findById(UUID id);

  List<Feature> findAllByRoom(UUID roomId);

  List<FeatureData> findAllDataByFeature(UUID featureId);

  void recordData(FeatureData featureData);
}
