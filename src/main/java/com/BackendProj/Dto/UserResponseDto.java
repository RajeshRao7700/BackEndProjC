package com.BackendProj.Dto;

import lombok.AllArgsConstructor;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    
}
