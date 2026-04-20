
package com.BackendProj.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendProj.Dto.RegistrationCreateDto;
import com.BackendProj.Dto.RegistrationResponseDto;
import com.BackendProj.Service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping
    public RegistrationResponseDto register(@RequestBody RegistrationCreateDto dto) {
        return service.registerUser(dto);
    }

    @GetMapping
    public List<RegistrationResponseDto> getAllRegistrations() {
        return service.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public RegistrationResponseDto getRegistrationById(@PathVariable Long id) {
        return service.getRegistrationById(id);
    }
}

