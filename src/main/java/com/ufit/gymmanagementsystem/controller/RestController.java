package com.ufit.gymmanagementsystem.controller;



import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.model.UserInfo;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import com.ufit.gymmanagementsystem.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;


@Controller
public class RestController {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

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
    public ResponseEntity<?> insertToDb(UserInfo userInfo) {
//        if (userInfo.getFirstName() == null || userInfo.getFirstName().equals("")) {
//            throw new IllegalStateException("Something went wrong");
//        }
        userInfoRepo.save(userInfo);

        return ResponseEntity.ok("Hello "+userInfo.getFirstName()+" you have been registered");

    }

    @PostMapping("/save-credentials")
    public ResponseEntity<?> insertToDb(UserCredentials userCredentials) {
        userCredentialsRepo.save(userCredentials);
        return ResponseEntity.ok("Data saved into the table");

    }
}