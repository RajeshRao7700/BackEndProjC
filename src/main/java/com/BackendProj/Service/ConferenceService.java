package com.BackendProj.Service;

import com.BackendProj.Dto.ConferenceCreateDto;
import com.BackendProj.Dto.ConferenceResponseDto;


public interface ConferenceService {
    ConferenceResponseDto createConference(ConferenceCreateDto conferenceCreateDto);
    ConferenceResponseDto getConferenceById(Long id);
    void deleteConference(Long id);
}
