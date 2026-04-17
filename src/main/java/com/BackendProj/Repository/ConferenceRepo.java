package com.BackendProj.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendProj.Entity.Conference;

public interface ConferenceRepo extends JpaRepository<Conference, Long>
 {
    Optional<Conference> findByShortname(String shortname);
    
}
