package com.smart.home.lara.messaging.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/** lara Created by Catalin on 2/13/2021 */
@Getter
@Setter
public class MessageDto {
  private UUID featureId;
  private Long recordedTimestamp;
  private Double value;
}
