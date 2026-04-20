
package com.BackendProj.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "*")
public class ConferenceController {

    private final ConferenceService service;

    @GetMapping
public List<ConferenceResponseDto> getAllConferences() {
    return service.getAllConferences();
}

@GetMapping("/{id}")
public ConferenceResponseDto getConferenceById(@PathVariable Long id) {
    return service.getConferenceById
    (id);
}
    @PostMapping
    public ConferenceResponseDto create(@RequestBody ConferenceCreateDto dto) {
        return service.createConference(dto);
    }
}