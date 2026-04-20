
package com.BackendProj.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendProj.Entity.Conference;
import com.BackendProj.Entity.Registration;



import com.BackendProj.Entity.User;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    boolean existsByUserAndConference(User user, Conference conference);
}
