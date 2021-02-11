package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.repo.repository.FeatureInMemoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeatureRepositoryAdapter implements FeatureRepository {

  private final FeatureInMemoryRepository featureInMemoryRepository;

  @Override
  public Feature create(Feature feature) {
    return featureInMemoryRepository.create(feature);
  }

  @Override
  public List<Feature> findAllByRoom(UUID roomId) {
    return featureInMemoryRepository.findAllByRoom(roomId);
  }

  @Override
  public List<FeatureData> findAllDataByFeature(UUID featureId) {
    return featureInMemoryRepository.findAllDataByFeature(featureId);
  }

  @Override
  public FeatureData recordData(FeatureData featureData) {
    return featureInMemoryRepository.recordData(featureData);
  }
}
