package com.school.app.db.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Abstract entity for automatic population of created/modified on & created/modified by meta information.
 *
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseMetaInfoEntity extends BaseEntity {

  @CreatedBy
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by", nullable = false, updatable = false)
  private UserEntity createdBy;

  @LastModifiedBy
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on", nullable = false, updatable = false)
  private Date createdOn;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_on")
  private Date modifiedOn;

  public UserEntity getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(UserEntity modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public UserEntity getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(UserEntity createdBy) {
    this.createdBy = createdBy;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), 7);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return super.equals(o);
  }
}
