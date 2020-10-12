package com.ufit.gymmanagementsystem.repo;

import com.ufit.gymmanagementsystem.model.UserInfo;
import com.ufit.gymmanagementsystem.model.UserPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, UserPk> {

}
