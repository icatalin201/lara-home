package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.repo.FeatureRepositoryAdapter;
import com.smart.home.lara.repo.RoomRepositoryAdapter;
import com.smart.home.lara.repo.repository.FeatureDataJpaRepository;
import com.smart.home.lara.repo.repository.FeatureJpaRepository;
import com.smart.home.lara.repo.repository.RoomJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
@EnableJpaRepositories(basePackages = "com.smart.home.lara.repo.repository")
@EntityScan(basePackages = "com.smart.home.lara.repo.entity")
@ComponentScan(basePackages = "com.smart.home.lara.repo")
public class RepositoryConfiguration {

  @Bean
  public FeatureRepository featureRepository(
      ModelMapper modelMapper,
      FeatureJpaRepository featureJpaRepository,
      FeatureDataJpaRepository featureDataJpaRepository) {
    return new FeatureRepositoryAdapter(
        modelMapper, featureJpaRepository, featureDataJpaRepository);
  }

  @Bean
  public RoomRepository roomRepository(
      ModelMapper modelMapper, RoomJpaRepository roomJpaRepository) {
    return new RoomRepositoryAdapter(modelMapper, roomJpaRepository);
  }
}
