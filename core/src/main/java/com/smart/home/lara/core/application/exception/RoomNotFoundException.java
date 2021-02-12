package com.smart.home.lara.core.application.exception;

/** lara Created by Catalin on 2/12/2021 */
public class RoomNotFoundException extends RuntimeException {
  public RoomNotFoundException() {
    super("Room was not found");
  }
}
