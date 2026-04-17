package com.BackendProj.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RegistrationCreateDto {

    private String name;
    private String email;
    private String phone;
    private Long conferenceId;
    private LocalDateTime registeredAt;
    
    
}
