package com.school.app.service;


import com.school.app.db.entity.UserEntity;
import com.school.app.db.repository.UsersRepository;
import com.school.app.exception.ApiException;
import com.school.app.exception.ResourceNotFoundException;
import com.school.app.mapper.UserMapper;
import com.school.app.model.Taxes;
import com.school.app.model.request.SalaryRequest;
import com.school.app.model.request.UserSearchRequest;
import com.school.app.model.user.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Service for managing {@link User} users.
 */
@Validated
@Service
public class UsersService {

  private UsersRepository usersRepository;
  private UserMapper userMapper;

  @Autowired
  public UsersService(UsersRepository usersRepository, UserMapper userMapper) {
    this.usersRepository = usersRepository;
    this.userMapper = userMapper;
  }

  /**
   * Performs search for {@link UserEntity} using the id as the search criteria.
   *
   * @param id a Long containing the username of the user that is going to be searched.
   * @return the found {@link User} or {@link Optional#empty()}.
   */

  @Transactional
  public User findUserById(Long id) {
    return usersRepository.findById(id).map(userMapper::fromEntity).orElseThrow(() ->
        new ResourceNotFoundException(id));
  }

  /**
   * Get all users that are present in the database
   *
   * @return List all users
   */
  @Transactional
  public List<User> getAllUsers() {
    return usersRepository.findAll().stream().map(userMapper::fromEntity).collect(Collectors.toList());
  }


  /**
   * Performs user creation for {@link UserEntity} using the provided criteria.
   *
   * @param userCreateRequest request containing the insertion criteria related to {@link UserEntity}.
   * @return the inserted model {@link User}.
   */
  @Transactional
  public User create(User userCreateRequest) {
    return userMapper.fromEntity(usersRepository.save(userMapper.toEntity(userCreateRequest)));
  }

  /**
   * Calculates gross or net salary depending on the parameter of the request
   *
   * @param salaryRequest object containing info about salary to be calculated {@link SalaryRequest}.
   * @return the calculated salary {@link Double}.
   */
  @Transactional
  public Double calculateSalary(SalaryRequest salaryRequest) {
    if (salaryRequest.getNetSalary() != null) {
      return calculateGrossSalary(salaryRequest.getNetSalary());
    } else if (salaryRequest.getGrossSalary() != null) {
      return calculateNetSalary(salaryRequest.getGrossSalary());
    } else {
      throw new ApiException("Ju lutem vendosni një vlerë");
    }
  }

  /**
   * Gets all users based on search request
   * @param userSearchRequest object containing filtering information
   * @param pageable object containing data about items/page and ordering {@link UserSearchRequest}.
   * @return matched users {@link Page<User>}.
   */
  @Transactional
  public Page<User> findBySearchCriteria(UserSearchRequest userSearchRequest, Pageable pageable) {
    return usersRepository.findUserBySearchCriteria(userSearchRequest, pageable).map(userMapper::fromEntity);
  }

  private Double calculateGrossSalary(Double netSalary) {
    double salaryWithoutIncomeTax = calculateIncomeTax(netSalary);
    return netSalary + salaryWithoutIncomeTax + netSalary * Taxes.EMPLOYEE_SOCIAL_CONTRIBUTION.getCoefficient()
        + netSalary * Taxes.EMPLOYER_SOCIAL_CONTRIBUTION.getCoefficient()
        + netSalary * Taxes.HEALTH_CONTRIBUTION.getCoefficient();
  }

  private Double calculateNetSalary(Double grossSalary) {
    double salaryWithoutIncomeTax = calculateIncomeTax(grossSalary);
    return grossSalary - salaryWithoutIncomeTax - grossSalary * Taxes.EMPLOYEE_SOCIAL_CONTRIBUTION
        .getCoefficient() - grossSalary * Taxes.EMPLOYER_SOCIAL_CONTRIBUTION.getCoefficient()
        - grossSalary * Taxes.HEALTH_CONTRIBUTION.getCoefficient();
  }

  private Double calculateIncomeTax(Double salary) {
    if (salary <= 30000) {
      return salary * Taxes.INCOME_TAX_0.getCoefficient();
    } else if (salary <= 150000) {
      return salary - salary * Taxes.INCOME_TAX_1.getCoefficient();
    } else {
      return salary - salary * Taxes.INCOME_TAX_2.getCoefficient();
    }
  }
}
