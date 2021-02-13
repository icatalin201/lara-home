package com.smart.home.lara.core.application.port.primary;

import java.time.LocalDateTime;
import java.util.UUID;

/** lara Created by Catalin on 2/13/2021 */
public interface FeatureDataPort {
  void add(UUID featureId, Double value, LocalDateTime recordedOn);
}
