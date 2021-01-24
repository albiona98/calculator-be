package com.school.app.db.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Abstract entity for automatic population of created/modified on & created/modified and active by meta information.
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseMetaInfoActivatableEntity extends BaseMetaInfoEntity {

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
    if (!(o instanceof BaseMetaInfoActivatableEntity)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseMetaInfoActivatableEntity that = (BaseMetaInfoActivatableEntity) o;
    return
        Objects.equals(active, that.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active);
  }
}
