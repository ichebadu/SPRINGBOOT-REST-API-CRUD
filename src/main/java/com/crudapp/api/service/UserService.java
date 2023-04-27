package com.crudapp.api.service;

import com.crudapp.api.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser( UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto updateUser(UserDto userDto, Long id);
    void delete(long id);


}
