
package com.BackendProj.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendProj.Dto.RegistrationCreateDto;
import com.BackendProj.Service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping
    public String register(@RequestBody RegistrationCreateDto dto) {
        return service.registerUser(dto);
    }
}