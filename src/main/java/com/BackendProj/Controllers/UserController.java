
package com.BackendProj.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    @GetMapping
public List<UserResponseDto> getAllUsers() {
    return service.getAllUsers();
}

@GetMapping("/{id}")
public UserResponseDto getUserById(@PathVariable Long id) {
    return service.getUserById(id);
}

    @PostMapping
    public UserResponseDto create(@RequestBody UserCreateDto dto) {
        return service.createUser(dto);
    }
}
