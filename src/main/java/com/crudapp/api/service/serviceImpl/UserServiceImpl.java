package com.crudapp.api.service.serviceImpl;

import com.crudapp.api.Repository.UserRepository;
import com.crudapp.api.dto.UserDto;
import com.crudapp.api.entity.User;
import com.crudapp.api.exceptions.ResourceNotFoundException;
import com.crudapp.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public  UserDto createUser( UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        UserDto userResponse = mapToTDO(newUser);
        return userResponse;
    }

    @Override
    public List< UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user->mapToTDO(user)).collect(Collectors.toList());
    }

    @Override
    public  UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
        return mapToTDO(user);
    }

    @Override
    public  UserDto updateUser(UserDto userDto, Long id) {
        User user  = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        User updateUser= userRepository.save(user);
        return mapToTDO(updateUser);
    }
    @Override
    public void delete(long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
        userRepository.delete(user);
    }
    private UserDto mapToTDO(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto ;
    }
    //convert dto to entity
    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        return user;
    }

}
