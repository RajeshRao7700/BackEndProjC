
package com.BackendProj.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendProj.Dto.ConferenceCreateDto;
import com.BackendProj.Dto.ConferenceResponseDto;
import com.BackendProj.Service.ConferenceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService service;

    @PostMapping
    public ConferenceResponseDto create(@RequestBody ConferenceCreateDto dto) {
        return service.createConference(dto);
    }
}