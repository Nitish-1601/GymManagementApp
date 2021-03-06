package com.ufit.gymmanagementsystem.repo;

import com.ufit.gymmanagementsystem.model.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPersonalInfoRepo extends JpaRepository<UserPersonalInfo, String> {
}