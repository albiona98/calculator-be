package com.school.app.db.repository;

import com.querydsl.core.BooleanBuilder;
import com.school.app.db.entity.QUserEntity;
import com.school.app.db.entity.UserEntity;
import com.school.app.model.request.UserSearchRequest;
import java.util.Optional;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Persistence DAO for performing CRUD operations upon {@link UserEntity}.
 */
@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {

  default Page<UserEntity> findUserBySearchCriteria(UserSearchRequest userSearchRequest, Pageable pageable) {
    QUserEntity qUserEntity = QUserEntity.userEntity;

    BooleanBuilder where = new BooleanBuilder();
    if (userSearchRequest != null) {
      if (userSearchRequest.getName() != null) {
        where.and(qUserEntity.name.containsIgnoreCase(userSearchRequest.getName()));
      }
      if (userSearchRequest.getJobPosition() != null) {
        where.and(qUserEntity.jobPosition.like(userSearchRequest.getJobPosition()));
      }
      if (userSearchRequest.getSalary() != null) {
        where.and(qUserEntity.salary.eq(userSearchRequest.getSalary()));
      }
    }
    return findAll(where, pageable);
  }
}
