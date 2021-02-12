package com.smart.home.lara.repo.repository;

import com.smart.home.lara.repo.entity.FeatureDataEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
public interface FeatureDataEntityRepository
    extends ReactiveCrudRepository<FeatureDataEntity, UUID> {}
