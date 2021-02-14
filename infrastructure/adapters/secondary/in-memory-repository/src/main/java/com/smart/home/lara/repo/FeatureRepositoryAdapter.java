package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.exception.FeatureNotFoundException;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.repo.entity.FeatureDataEntity;
import com.smart.home.lara.repo.entity.FeatureEntity;
import com.smart.home.lara.repo.repository.FeatureDataJpaRepository;
import com.smart.home.lara.repo.repository.FeatureJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class FeatureRepositoryAdapter implements FeatureRepository {

  private final ModelMapper modelMapper;
  private final FeatureJpaRepository featureJpaRepository;
  private final FeatureDataJpaRepository featureDataJpaRepository;

  @Override
  @Transactional
  public void create(Feature feature) {
    FeatureEntity entity = modelMapper.map(feature, FeatureEntity.class);
    if (entity.getId() == null) {
      entity.setId(UUID.randomUUID());
    }
    featureJpaRepository.save(entity);
  }

  @Override
  @Transactional
  public Feature findById(UUID id) {
    Feature feature =
        featureJpaRepository
            .findById(id)
            .map(featureEntity -> modelMapper.map(featureEntity, Feature.class))
            .orElseThrow(FeatureNotFoundException::new);
    feature.setDataHistory(findAllDataByFeature(id));
    return feature;
  }

  @Override
  @Transactional
  public List<Feature> findAllByRoom(UUID roomId) {
    return featureJpaRepository.findAllByRoomId(roomId).stream()
        .map(featureEntity -> modelMapper.map(featureEntity, Feature.class))
        .peek(feature -> feature.setDataHistory(findAllDataByFeature(feature.getId())))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public List<FeatureData> findAllDataByFeature(UUID featureId) {
    return featureDataJpaRepository.findAllByFeatureId(featureId).stream()
        .map(featureDataEntity -> modelMapper.map(featureDataEntity, FeatureData.class))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void recordData(FeatureData featureData) {
    FeatureDataEntity entity = modelMapper.map(featureData, FeatureDataEntity.class);
    featureDataJpaRepository.save(entity);
  }
}
