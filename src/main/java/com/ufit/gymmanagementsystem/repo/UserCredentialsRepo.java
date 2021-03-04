package com.ufit.gymmanagementsystem.repo;

import com.ufit.gymmanagementsystem.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo extends JpaRepository<UserCredentials, String> {
}
