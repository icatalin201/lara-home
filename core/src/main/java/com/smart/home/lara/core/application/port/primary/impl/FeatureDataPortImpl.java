package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/** lara Created by Catalin on 2/13/2021 */
@RequiredArgsConstructor
public class FeatureDataPortImpl implements FeatureDataPort {

  private final FeatureRepository featureRepository;

  @Override
  public void add(UUID featureId, Double value, LocalDateTime recordedOn) {
    Feature feature = featureRepository.findById(featureId);
    FeatureData featureData = new FeatureData();
    featureData.setFeature(feature);
    featureData.setRecordedOn(recordedOn);
    featureData.setValue(value);
    featureRepository.recordData(featureData);
  }
}
