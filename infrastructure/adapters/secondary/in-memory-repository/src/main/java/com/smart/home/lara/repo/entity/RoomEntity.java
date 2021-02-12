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
@Table(name = "rooms")
public class RoomEntity {
  @Id @GeneratedValue private UUID id;

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "room_type", nullable = false)
  private RoomType type;
}
