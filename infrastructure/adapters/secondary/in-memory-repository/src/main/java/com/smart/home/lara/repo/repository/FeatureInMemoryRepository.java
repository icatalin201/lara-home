package com.smart.home.lara.repo.repository;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/** lara Created by Catalin on 2/11/2021 */
public class FeatureInMemoryRepository {

  private final List<Feature> features = new ArrayList<>();
  private final List<FeatureData> featureDataHistory = new ArrayList<>();

  public Feature create(Feature feature) {
    features.add(feature);
    return feature;
  }

  public List<Feature> findAllByRoom(UUID roomId) {
    return features.stream()
        .filter(feature -> feature.getRoom().getId() == roomId)
        .collect(Collectors.toList());
  }

  public List<FeatureData> findAllDataByFeature(UUID featureId) {
    return featureDataHistory.stream()
        .filter(data -> data.getFeature().getId() == featureId)
        .collect(Collectors.toList());
  }

  public FeatureData recordData(FeatureData featureData) {
    featureDataHistory.add(featureData);
    return featureData;
  }
}
