package com.smart.home.lara.repo.repository;

import com.smart.home.lara.repo.entity.FeatureDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
public interface FeatureDataJpaRepository extends JpaRepository<FeatureDataEntity, UUID> {
  List<FeatureDataEntity> findAllByFeatureId(UUID featureId);
}
