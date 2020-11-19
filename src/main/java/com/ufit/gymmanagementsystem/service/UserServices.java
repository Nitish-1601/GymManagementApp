package com.ufit.gymmanagementsystem.service;

import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.model.UserPk;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserCredentialsRepo userCredentialsRepo;

    public UserCredentials getById(String id)
    {
        return userCredentialsRepo.getOne(new UserPk(id));
    }
}
