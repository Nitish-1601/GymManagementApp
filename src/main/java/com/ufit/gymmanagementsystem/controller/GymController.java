package com.ufit.gymmanagementsystem.controller;

import com.ufit.gymmanagementsystem.model.*;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import com.ufit.gymmanagementsystem.repo.UserPersonalInfoRepo;
import com.ufit.gymmanagementsystem.repo.UserRegistrationRepo;
import com.ufit.gymmanagementsystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;


@Controller
public class GymController {
    @Autowired
    private UserRegistrationRepo userRegistrationRepo;
    @Autowired
    private UserPersonalInfoRepo userPersonalInfoRepo;
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;
    @Autowired
    private UserServices userServices;

    @GetMapping("/gym")
    public String home() {
        return "gym.html";
    }

    @GetMapping("/register")
    public String register() {

        return "registration.html";
    }


    @GetMapping("/login")
    public String login() {
        return "login.html";
    }


    @PostMapping("/save-user")
    public ResponseEntity<?> insertToDb(UserRegistration userRegistration ,UserPersonalInfo userPersonalInfo, UserCredentials userCredentials) {
//        if (userPersonalInfo.getFirstName() == null || userPersonalInfo.getFirstName().equals("")) {
//            throw new IllegalStateException("Something went wrong");
//        }
        userRegistrationRepo.save(userRegistration);
        userPersonalInfoRepo.save(userPersonalInfo);
        userCredentialsRepo.save(userCredentials);
        return ResponseEntity.ok("Hello "+ userPersonalInfo.getFirstName()+" you have been registered");

    }

    @PostMapping("/verify")
    public ResponseEntity<?> fetchAndVerify(LoginVerifier loginVerifier ) {
            if (userServices.getById(loginVerifier.getEmail()).getPassword().equals(loginVerifier.getPassword()))
                return ResponseEntity.ok("hi!! you are logged in");
            else
                return ResponseEntity.ok("Username or Password not correct");


    }

}