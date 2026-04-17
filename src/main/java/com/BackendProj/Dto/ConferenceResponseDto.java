package com.BackendProj.Dto;

import java.time.LocalDate;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConferenceResponseDto {
    private Long id;
    private String name;
    private String shortname;
    private LocalDate startDate;
    private LocalDate endDate;
    
}
