package com.springprogramming.restapi.UserAuth.Services;

import com.springprogramming.restapi.UserAuth.Entity.User;
import com.springprogramming.restapi.UserAuth.dto.UserDto;

public interface UserService {
 User findByUsername(String username);

 User save(UserDto userDto);

}
