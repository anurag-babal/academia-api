package com.example.academia.login.data;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.academia.login.domain.Role;
import com.example.academia.login.domain.User;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRepository {
  private final UserEntityDao userEntityDao;

  public User getUserByUsername(String username) {
    return mapToDomainUser(getUserEntityByUsername(username));
  }

  public User saveUser(User user) {
    UserEntity userEntity = mapToEntityUser(user);
    UserEntity savedUserEntity = userEntityDao.save(userEntity);
    return mapToDomainUser(savedUserEntity);
  }

  private UserEntity getUserEntityByUsername(String username) {
    return userEntityDao.findByUsername(username)
        .orElseThrow(() -> new EntityNotFoundException("Invalid username."));
  }

  private User mapToDomainUser(UserEntity entity) {
    return User.builder()
        .username(entity.getUsername())
        .password(entity.getPassword())
        .enabled(entity.isEnabled())
        .roles(mapToDomainRoles(entity.getRoleEntities()))
        .build();
  }

  private UserEntity mapToEntityUser(User user) {
    return null;
  }

  private Role mapToDomainRole(RoleEntity entity) {
    return Role.valueOf(entity.getName());
  }

  private List<Role> mapToDomainRoles(Collection<RoleEntity> entities) {
    return entities.stream().map(this::mapToDomainRole).toList();
  }
}
