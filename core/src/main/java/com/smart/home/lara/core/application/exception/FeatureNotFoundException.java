package com.smart.home.lara.core.application.exception;

/** lara Created by Catalin on 2/12/2021 */
public class FeatureNotFoundException extends RuntimeException {
  public FeatureNotFoundException() {
    super("Feature was not found");
  }
}
