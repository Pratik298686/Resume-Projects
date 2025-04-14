package com.springprogramming.restapi.UserAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprogramming.restapi.UserAuth.Entity.User;
import com.springprogramming.restapi.UserAuth.dto.UserDto;

public interface UserRepository extends JpaRepository<User, Long> {

	 User findByUsername(String username);

	 User save(UserDto userDto);
	}
