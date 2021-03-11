package com.smart.home.lara.core.application.port.primary;

import com.smart.home.lara.core.domain.model.Feature;

import java.util.List;
import java.util.UUID;

/** lara Created by icatalin201 on 11.03.2021 */
public interface FeaturePort {

  void create(UUID roomId, Feature feature);

  List<Feature> findAllByRoom(UUID roomId);
}
