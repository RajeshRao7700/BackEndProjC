
package com.BackendProj.Service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BackendProj.Dto.RegistrationCreateDto;
import com.BackendProj.Dto.RegistrationResponseDto;
import com.BackendProj.Entity.Conference;
import com.BackendProj.Entity.Registration;
import com.BackendProj.Entity.User;
import com.BackendProj.Repository.ConferenceRepo;
import com.BackendProj.Repository.RegistrationRepo;
import com.BackendProj.Repository.UserRepo;
import com.BackendProj.Service.RegistrationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

        private final UserRepo userRepo;
        private final ConferenceRepo confRepo;
        private final RegistrationRepo regRepo;

    @Override
    public RegistrationResponseDto registerUser(RegistrationCreateDto dto) {
        // 1. Find user by email
        User user = userRepo.findByEmail(dto.getEmail()).orElse(null);

        // 2. If not exists → create new user
        if (user == null) {
            user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
            user = userRepo.save(user);
        }

        // 3. Get conference
        Conference conference = confRepo.findById(dto.getConferenceId())
            .orElseThrow(() -> new RuntimeException("Conference not found"));

        // 4. Check duplicate registration
        boolean alreadyRegistered = regRepo.existsByUserAndConference(user, conference);
        if (alreadyRegistered) {
            throw new RuntimeException("User already registered for this conference");
        }

        // 5. Create registration
        Registration registration = Registration.builder()
            .user(user)
            .conference(conference)
            .registrationStatus("REGISTERED")
            .createdAt(LocalDateTime.now())
            .build();
        registration = regRepo.save(registration);

        // 6. Return response DTO
        return RegistrationResponseDto.builder()
            .RegistrationId(registration.getId())
            .userName(user.getName())
            .userEmail(user.getEmail())
            .conferenceName(conference.getName())
            .registrationStatus(registration.getRegistrationStatus())
            .build();
    }

    @Override
    public List<RegistrationResponseDto> getAllRegistrations() {
        return regRepo.findAll().stream()
                .map(reg -> RegistrationResponseDto.builder()
                        .RegistrationId(reg.getId())
                        .userName(reg.getUser().getName())
                        .userEmail(reg.getUser().getEmail())
                        .conferenceName(reg.getConference().getName())
                        .registrationStatus(reg.getRegistrationStatus())
                        .build())
                .toList();
    }

    @Override
    public RegistrationResponseDto getRegistrationById(Long id) {
        Registration reg = regRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        return RegistrationResponseDto.builder()
                .RegistrationId(reg.getId())
                .userName(reg.getUser().getName())
                .userEmail(reg.getUser().getEmail())
                .conferenceName(reg.getConference().getName())
                .registrationStatus(reg.getRegistrationStatus())
                .build();
    }
}
