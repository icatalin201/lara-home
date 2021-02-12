package com.smart.home.lara.repo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@Setter
@Entity
@Table(name = "features")
public class FeatureEntity {
  @Id @GeneratedValue private UUID id;

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "feature_type", nullable = false)
  private FeatureType type;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  private RoomEntity room;
}
