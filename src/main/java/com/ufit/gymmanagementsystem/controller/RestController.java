package com.ufit.gymmanagementsystem.controller;


import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.model.UserInfo;
import com.ufit.gymmanagementsystem.model.UserPk;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import com.ufit.gymmanagementsystem.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Controller
public class RestController {
    @Autowired
    private UserInfoRepo userInfoRepo;
    private UserCredentialsRepo userCredentialsRepo;

    @GetMapping("/signin")
    public ResponseEntity<?> test() {
        UserPk userPk = new UserPk("1510992078");
        return ResponseEntity.of(Optional.of(userInfoRepo.findById(userPk)));
    }

    @PostMapping("/save-info")
    public ResponseEntity<?> insertToDb(@RequestBody UserInfo userInfo) {
        if (userInfo.getFirstName() == null || userInfo.getFirstName().equals("")) {
            throw new IllegalStateException("Something went wrong");
        }
        userInfoRepo.save(userInfo);
        return ResponseEntity.ok("Data saved into the table");

    }
    @PostMapping("/save-credentials")
    public ResponseEntity<?> insertToDb(@RequestBody UserCredentials userCredentials) {
        userCredentialsRepo.save(userCredentials);
        return ResponseEntity.ok("Data saved into the table");

    }
}