package com.school.app.model;

import java.util.Objects;

/**
 * Base identifiable model for examination DTOs.
 * <p>
 * Allows generics for proper method chaining in sub classes.
 *
 * @param <M> the type of the sub class
 */
public abstract class BaseModel<M extends BaseModel> {

  private Long id;

  public Long getId() {
    return id;
  }

  public M setId(Long id) {
    this.id = id;
    return (M) this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseModel)) {
      return false;
    }
    BaseModel<?> baseModel = (BaseModel<?>) o;
    return Objects.equals(id, baseModel.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "BaseModel{" +
        "id=" + id +
        '}';
  }
}
