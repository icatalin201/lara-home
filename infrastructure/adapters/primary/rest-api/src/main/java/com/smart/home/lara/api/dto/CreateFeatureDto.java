package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.FeatureType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@Setter
public class CreateFeatureDto {
  @NotBlank private String name;
  @NotNull private FeatureType type;
}
