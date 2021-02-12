package com.smart.home.lara.repo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@Setter
public class RoomEntity {
  @Id private UUID id;
  private String name;
  private RoomType type;
}
