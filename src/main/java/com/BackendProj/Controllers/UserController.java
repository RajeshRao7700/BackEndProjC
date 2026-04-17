
package com.BackendProj.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendProj.Dto.UserCreateDto;
import com.BackendProj.Dto.UserResponseDto;
import com.BackendProj.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService.userService service;

    @PostMapping
    public UserResponseDto create(@RequestBody UserCreateDto dto) {
        return service.createUser(dto);
    }
}
