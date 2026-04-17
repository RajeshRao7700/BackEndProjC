package com.BackendProj.Dto;


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
public class RegistrationResponseDto {

    private Long RegistrationId;
    private String userName;
    private String userEmail;
    private String conferenceName;
    private String registrationStatus;
    
}
