package com.school.app.model;

import java.util.Objects;

/**
 * Abstract class defining information when in a model is provided soft deletion. Allows generics for proper method
 * chaining in sub classes.
 *
 * @param <M> type of the sub class
 */
public abstract class BaseActivatableModel<M extends BaseActivatableModel<M>> extends BaseModel<M> {

  private Boolean active;

  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseActivatableModel)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseActivatableModel<?> that = (BaseActivatableModel<?>) o;
    return Objects.equals(active, that.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active);
  }
}
