package com.school.app.model.user;

import com.school.app.model.BaseMetaInfoActivatableModel;
import java.util.Objects;

/**
 * DTO for user in the Calculator system
 */
public class User extends BaseMetaInfoActivatableModel<User> {

  private String name;

  private String lastName;

  private String email;

  private String password;

  private String mobile;

  private String address;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
    if (!(o instanceof User)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(lastName, user.lastName) &&
        Objects.equals(email, user.email) &&
        Objects.equals(password, user.password) &&
        Objects.equals(mobile, user.mobile) &&
        Objects.equals(address, user.address) &&
        Objects.equals(jobPosition, user.jobPosition) &&
        Objects.equals(salary, user.salary);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), name, lastName, email, password, mobile, address, jobPosition, salary);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", mobile='" + mobile + '\'' +
        ", address='" + address + '\'' +
        ", passportNr='" + jobPosition + '\'' +
        ", qkrNr='" + salary + '\'' +
        '}';
  }
}
