
package com.BackendProj.Service.impl;

import org.springframework.stereotype.Service;

import com.BackendProj.Dto.ConferenceCreateDto;
import com.BackendProj.Dto.ConferenceResponseDto;
import com.BackendProj.Entity.Conference;
import com.BackendProj.Repository.ConferenceRepo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements com.BackendProj.Service.ConferenceService {

    private final ConferenceRepo repository;

    @Override
    public ConferenceResponseDto createConference(ConferenceCreateDto dto) {
        Conference conf = Conference.builder()
            .name(dto.getName())
            .shortname(dto.getShortname())
            .startDate(dto.getStartDate())
            .endDate(dto.getEndDate())
            .build();

        Conference saved = repository.save(conf);

        return ConferenceResponseDto.builder()
            .id(saved.getId())
            .name(saved.getName())
            .shortname(saved.getShortname())
            .startDate(saved.getStartDate())
            .endDate(saved.getEndDate())
            .build();
    }

    @Override
    public ConferenceResponseDto getConferenceById(Long id) {
        Conference conf = repository.findById(id).orElseThrow(() -> new RuntimeException("Conference not found"));
        return ConferenceResponseDto.builder()
                .id(conf.getId())
                .name(conf.getName())
                .shortname(conf.getShortname())
                .startDate(conf.getStartDate())
                .endDate(conf.getEndDate())
                .build();
    }

    @Override
    public void deleteConference(Long id) {
        repository.deleteById(id);
    }
}