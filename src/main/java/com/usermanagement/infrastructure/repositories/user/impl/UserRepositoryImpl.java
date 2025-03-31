// /src/main/java/com/usermanagement/infrastructure/repositories/user/impl/UserRepositoryImpl.java

package com.usermanagement.infrastructure.repositories.user.impl;

import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.infrastructure.repositories.user.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

  @PersistenceContext private EntityManager entityManager;

  @Override
  @Transactional
  public UserEntity createUser(UserEntity user) {
    entityManager.persist(user);
    return user;
  }

  @Override
  public UserEntity findUserByEmail(String email) {
    var results =
        entityManager
            .createQuery("SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class)
            .setParameter("email", email)
            .getResultList();

    return results.isEmpty() ? null : results.get(0);
  }
}
