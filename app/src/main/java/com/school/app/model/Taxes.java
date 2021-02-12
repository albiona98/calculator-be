package com.school.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Taxes {
  INCOME_TAX_0(0.0),
  INCOME_TAX_1(0.13),
  INCOME_TAX_2(0.23),
  HEALTH_CONTRIBUTION(0.017),
  EMPLOYER_SOCIAL_CONTRIBUTION(0.095),
  EMPLOYEE_SOCIAL_CONTRIBUTION(0.15);

  private final Double coefficient;

  public static Map<Double, Taxes> ENUM_MAP = Stream
      .of(Taxes.values())
      .collect(Collectors.toMap(s -> s.coefficient, Function.identity()));

  Taxes(Double coefficient) {
    this.coefficient = coefficient;
  }

  @JsonValue
  public Double getCoefficient() {
    return coefficient;
  }

  @JsonCreator
  public static Taxes fromString(Double coeficient) {
    return Optional
        .ofNullable(ENUM_MAP.get(coeficient))
        .orElseThrow(() -> new IllegalArgumentException(String.valueOf(coeficient)));
  }
}
