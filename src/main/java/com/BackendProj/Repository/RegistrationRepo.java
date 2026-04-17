
package com.BackendProj.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.BackendProj.Entity.Registration;
import java.util.Optional;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    Optional<Registration> findByConferenceId(Long conferenceId);
}
