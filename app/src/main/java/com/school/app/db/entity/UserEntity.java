package com.school.app.db.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Persistence entity for user. Contains the needed information for user details.
 *
 */
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity extends BaseMetaInfoActivatableEntity {

  public static final String TABLE_NAME = "USERS";

  private String name;

  @Column(name = "last_name")
  private String lastName;

  private String email;

  private String mobile;

  private String address;

  @Column(name = "job_position")
  private String jobPosition;

  private Double salary;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getJobPosition() {
    return jobPosition;
  }

  public void setJobPosition(String jobPosition) {
    this.jobPosition = jobPosition;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserEntity)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    UserEntity that = (UserEntity) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(lastName, that.lastName) &&
        Objects.equals(email, that.email) &&
        Objects.equals(mobile, that.mobile) &&
        Objects.equals(address, that.address) &&
        Objects.equals(jobPosition, that.jobPosition) &&
        Objects.equals(salary, that.salary);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), name, lastName, email, mobile, address, jobPosition, salary);
  }

  @Override
  public String toString() {
    return "UserEntity{" +
        "name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", mobile='" + mobile + '\'' +
        ", address='" + address + '\'' +
        ", passportNr='" + jobPosition + '\'' +
        ", qkrNr='" + salary + '\'' +
        '}';
  }
}
