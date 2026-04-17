package com.BackendProj.Dto;

import java.time.LocalDate;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceCreateDto {
    
    private String name;
    private String shortname;
    private LocalDate startDate;
    private LocalDate endDate;

    
}
