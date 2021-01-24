package com.school.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Base Salary Calculator configurations.
 */
@Configuration
@ConfigurationProperties(prefix = "calculator")
public class CalculatorConfiguration {

  private String workingDirectory;

  public String getWorkingDirectory() {
    return workingDirectory;
  }

  public void setWorkingDirectory(String workingDirectory) {
    this.workingDirectory = workingDirectory;
  }

}
