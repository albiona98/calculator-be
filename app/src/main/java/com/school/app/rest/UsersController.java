package com.school.app.rest;

import com.school.app.model.CalculatedResult;
import com.school.app.model.request.SalaryRequest;
import com.school.app.model.request.UserSearchRequest;
import com.school.app.model.user.User;
import com.school.app.service.UsersService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for CRUD operations upon users.
 */
@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {

  private final UsersService usersService;

  @Autowired
  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }


  /**
   * Handles search request of ausers based on search request
   *
   * @param userSearchRequest object containing filtering information
   * @param pageable          object containing data about items/page and ordering {@link UserSearchRequest}.
   * @return matched users {@link Page<User>}.
   */
  @PutMapping("/search")
  public Page<User> getUsersBySearchCriteria(@RequestBody UserSearchRequest userSearchRequest, Pageable pageable) {
    return usersService.findBySearchCriteria(userSearchRequest, pageable);
  }

  /**
   * Handles register request for user
   *
   * @param user object containing data for user creation
   * @return the registered user general details {@link User}
   */
  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return usersService.create(user);
  }

  /**
   * Handles request for calculating net/gross salary
   *
   * @param salaryRequest object containing info about salary to be calculated {@link SalaryRequest}.
   * @return the calculated salary {@link Double}.
   */
  @PutMapping("/calculate")
  public CalculatedResult calculateSalary(@RequestBody SalaryRequest salaryRequest) {
    return usersService.calculateSalary(salaryRequest);
  }
}
