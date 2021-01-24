package com.school.app.db.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Abstract entity for automatic population of active.
 *
 */
@MappedSuperclass
public abstract class BaseActivatableEntity extends BaseEntity {

  @Column(name = "active", insertable = false)
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
    if (!(o instanceof BaseActivatableEntity)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseActivatableEntity that = (BaseActivatableEntity) o;
    return Objects.equals(active, that.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active);
  }
}
