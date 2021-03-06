package com.smart.home.lara.repo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@Setter
@Entity
@Table(name = "feature_data_history")
public class FeatureDataEntity {
  @Id @GeneratedValue private UUID id;

  @NotNull
  @Column(name = "value", nullable = false)
  private Double value;

  @NotNull
  @Column(name = "recorded_on", nullable = false)
  private LocalDateTime recordedOn;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "feature_id", nullable = false)
  private FeatureEntity feature;
}
