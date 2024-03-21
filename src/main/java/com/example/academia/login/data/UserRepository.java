package com.example.academia.login.data;

import com.example.academia.login.domain.Role;
import com.example.academia.login.domain.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRepository {
    private final UserEntityDao userEntityDao;
    private final RoleEntityDao roleEntityDao;

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

    private RoleEntity findRoleEntityByRole(Role role) {
        String name = role.toString();
        return roleEntityDao.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + name));
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
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEnabled(true);
        userEntity.setRoleEntities(user.getRoles().stream().map(this::findRoleEntityByRole).toList());

        return userEntity;
    }

    private Role mapToDomainRole(RoleEntity entity) {
        return Role.valueOf(entity.getName());
    }

    private List<Role> mapToDomainRoles(Collection<RoleEntity> entities) {
        return entities.stream().map(this::mapToDomainRole).toList();
    }
}
