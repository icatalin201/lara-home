package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.FeatureData;
import lombok.RequiredArgsConstructor;

/** lara Created by Catalin on 2/13/2021 */
@RequiredArgsConstructor
public class FeatureDataPortImpl implements FeatureDataPort {

  private final FeatureRepository featureRepository;

  @Override
  public void add(FeatureData featureData) {
    featureRepository.recordData(featureData);
  }
}
