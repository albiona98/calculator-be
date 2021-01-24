package com.school.app.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when given resource couldn't be found in the duty roster system.
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  private final Serializable resourceId;

  public ResourceNotFoundException(Serializable resourceId) {
    this.resourceId = resourceId;
  }

  public Serializable getResourceId() {
    return resourceId;
  }

}
