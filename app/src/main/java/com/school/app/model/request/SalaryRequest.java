package com.school.app.model.request;

public class SalaryRequest {
    private Double netSalary;

    private Double grossSalary;

  public Double getNetSalary() {
    return netSalary;
  }

  public void setNetSalary(Double netSalary) {
    this.netSalary = netSalary;
  }

  public Double getGrossSalary() {
    return grossSalary;
  }

  public void setGrossSalary(Double grossSalary) {
    this.grossSalary = grossSalary;
  }
}
