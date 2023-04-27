package com.crudapp.api.Repository;

import com.crudapp.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    UserDto
}
