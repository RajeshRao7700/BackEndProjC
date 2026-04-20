package com.BackendProj.Service;

import java.util.List;

import com.BackendProj.Dto.UserCreateDto;
import com.BackendProj.Dto.UserResponseDto;

public interface UserService {
        UserResponseDto createUser(UserCreateDto userCreateDto);
        UserResponseDto getUserById(Long id);
        List<UserResponseDto> getAllUsers();
        UserResponseDto updateUser(Long id, UserCreateDto userCreateDto);
        void deleteUser(Long id);
}
