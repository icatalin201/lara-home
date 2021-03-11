package com.smart.home.lara.core.domain.service;

import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.FeatureData;
import com.smart.home.lara.core.domain.model.Room;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/** lara Created by icatalin201 on 11.03.2021 */
@RequiredArgsConstructor
public class FeatureService implements FeaturePort {

  private final FeatureRepository featureRepository;
  private final RoomPort roomPort;

  @Override
  public void create(UUID roomId, Feature feature) {
    Room room = roomPort.findById(roomId);
    feature.setRoom(room);
    featureRepository.create(feature);
  }

  @Override
  public List<Feature> findAllByRoom(UUID roomId) {
    List<Feature> features = featureRepository.findAllByRoom(roomId);
    features.forEach(this::updateFeatureWithLastData);
    return features;
  }

  private void updateFeatureWithLastData(Feature feature) {
    FeatureData featureData =
        feature.getDataHistory().stream()
            .max(Comparator.comparing(FeatureData::getRecordedOn))
            .orElse(null);
    feature.setLastRecordedData(featureData);
  }
}
