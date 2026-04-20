package com.BackendProj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BackendProj.Dto.RegistrationCreateDto;
import com.BackendProj.Dto.RegistrationResponseDto;

@Service
public interface RegistrationService {
     RegistrationResponseDto registerUser(RegistrationCreateDto dto);
     List<RegistrationResponseDto> getAllRegistrations();
     RegistrationResponseDto getRegistrationById(Long id);
}
