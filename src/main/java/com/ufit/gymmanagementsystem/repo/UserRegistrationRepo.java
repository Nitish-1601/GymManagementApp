package com.ufit.gymmanagementsystem.repo;

import com.ufit.gymmanagementsystem.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration, String> {
}
