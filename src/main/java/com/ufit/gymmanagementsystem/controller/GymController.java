package com.ufit.gymmanagementsystem.controller;

import com.ufit.gymmanagementsystem.model.*;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import com.ufit.gymmanagementsystem.repo.UserPersonalInfoRepo;
import com.ufit.gymmanagementsystem.repo.UserRegistrationRepo;
import com.ufit.gymmanagementsystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class GymController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRegistrationRepo userRegistrationRepo;
    @Autowired
    private UserPersonalInfoRepo userPersonalInfoRepo;
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;
    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("gym")
    public String gym() {
        return "gym";
    }

    @GetMapping("/register")
    public String register() {
        return "registration";
    }
    @GetMapping("/diet")
    public String diet() {
        return "diet";
    }
    @GetMapping("/login_fail")
    public String login_fail() {
        return "login_fail";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/save-user")
    public String insertToDb(UserRegistration userRegistration ,UserPersonalInfo userPersonalInfo, UserCredentials userCredentials,LoginVerifier loginVerifier) {

        Optional<UserCredentials> optionalUserCredentials = userServices.findId(loginVerifier.getEmail());
        if(!optionalUserCredentials.isPresent()) {
            String encodedPassword = bCryptPasswordEncoder.encode(userRegistration.getPassword());
            userRegistration.setPassword(encodedPassword);
            userCredentials.setPassword(encodedPassword);
            userRegistrationRepo.save(userRegistration);
            userPersonalInfoRepo.save(userPersonalInfo);
            userCredentialsRepo.save(userCredentials);
            return "registerSuccessful";
        }
        return "registration_Fail";


    }


     //    this is manual verifier not using spring security

//    @PostMapping("/verify")
//    public String fetchAndVerify(LoginVerifier loginVerifier ) {
//        Optional<UserCredentials> optionalUserCredentials = userServices.findId(loginVerifier.getEmail());
//        if(!optionalUserCredentials.isPresent()) {
//            return "login_fail";
//        }
//        UserCredentials userCredentials = optionalUserCredentials.get();
//
//        if (!bCryptPasswordEncoder.matches(loginVerifier.getPassword(),userCredentials.getPassword())){
//            return "login_fail";
//        }
//        return "/gym";
//    }

}