package com.school.app.model;


import com.school.app.model.user.User;
import com.school.app.model.user.UserWithoutMetaInfo;
import java.util.Date;
import java.util.Objects;

/**
 * Abstract class defining meta information about who and when created and updated a model. Allows generics for proper
 * method chaining in sub classes.
 *
 * @param <M> type of the sub class
 */
public abstract class BaseMetaInfoModel<M extends BaseMetaInfoModel<M>> extends BaseModel<M> {

  private UserWithoutMetaInfo createdBy;

  private UserWithoutMetaInfo modifiedBy;

  private Date createdOn;

  private Date modifiedOn;

  public UserWithoutMetaInfo getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(UserWithoutMetaInfo createdBy) {
    this.createdBy = createdBy;
  }

  public UserWithoutMetaInfo getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(UserWithoutMetaInfo modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public M setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
    return (M) this;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public M setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
    return (M) this;
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

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), 7);
  }
}

