package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface FeatureRepository {
  Feature create(Feature feature);

  List<Feature> findAllByRoom(UUID roomId);

  List<FeatureData> findAllDataByFeature(UUID featureId);

  FeatureData recordData(FeatureData featureData);
}
