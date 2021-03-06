package com.smart.home.lara.api.exception;

import com.smart.home.lara.api.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** lara Created by Catalin on 3/6/2021 */
@RestControllerAdvice
public class RestApiControllerAdvice {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorDto> handle(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto(e.getMessage()));
  }
}
