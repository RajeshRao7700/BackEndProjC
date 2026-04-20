

package com.BackendProj.Service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.BackendProj.Dto.UserCreateDto;
import com.BackendProj.Dto.UserResponseDto;
import com.BackendProj.Entity.User;
import com.BackendProj.Repository.UserRepo;
import com.BackendProj.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo UserRepo;

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = UserRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {

        User user = User.builder()
                .name(userCreateDto.getName())
                .email(userCreateDto.getEmail())
                .phone(userCreateDto.getPhone())
                .build();

        User savedUser = UserRepo.save(user);
        return UserResponseDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .phone(savedUser.getPhone())
                .build();
    }

    // @Override
    // public UserResponseDto getUserById(Long id) {
    @Override
    public void deleteUser(Long id) {
        UserRepo.deleteById(id);
    }
    //     // TODO Auto-generated method stub
    //     return null;
    // }


    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = UserRepo.findAll();
        List<UserResponseDto> userDtos = new java.util.ArrayList<>();
        for (User user : users) {
            userDtos.add(UserResponseDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .build());
        }
        return userDtos;
    }


    @Override
    public UserResponseDto updateUser(Long id, UserCreateDto userCreateDto) {
        User user = UserRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        user.setPhone(userCreateDto.getPhone());
        User updatedUser = UserRepo.save(user);
        return UserResponseDto.builder()
                .id(updatedUser.getId())
                .name(updatedUser.getName())
                .email(updatedUser.getEmail())
                .phone(updatedUser.getPhone())
                .build();
    }

    // @Override
    // public void deleteUser(Long id) {
    //     // TODO Auto-generated method stub
        
    // }
    
}