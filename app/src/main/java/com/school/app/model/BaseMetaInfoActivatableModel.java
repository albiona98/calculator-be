package com.school.app.model;

import java.util.Objects;

/**
 * Abstract class defining meta information about who and when created and updated a model and if soft deletion is
 * provided for this model. Allows generics for proper method chaining in sub classes.
 *
 * @param <M> type of the sub class
 */
public abstract class BaseMetaInfoActivatableModel<M extends BaseMetaInfoActivatableModel<M>> extends
    BaseMetaInfoModel<M> {

  private Boolean active;

  public Boolean getActive() {
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
    if (!(o instanceof BaseMetaInfoActivatableModel)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseMetaInfoActivatableModel<?> that = (BaseMetaInfoActivatableModel<?>) o;
    return Objects.equals(active, that.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active);
  }
}
