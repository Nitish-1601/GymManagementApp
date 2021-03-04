package com.ufit.gymmanagementsystem.controller;

import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.model.UserPersonalInfo;
import com.ufit.gymmanagementsystem.model.UserRegistration;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import com.ufit.gymmanagementsystem.repo.UserPersonalInfoRepo;
import com.ufit.gymmanagementsystem.repo.UserRegistrationRepo;
import com.ufit.gymmanagementsystem.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class GymController {
    @Autowired
    EmailService emailService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRegistrationRepo userRegistrationRepo;
    @Autowired
    private UserPersonalInfoRepo userPersonalInfoRepo;
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

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
    public String insertToDb(UserRegistration userRegistration) {
        Optional<UserCredentials> optionalUserCredentials = userCredentialsRepo.findById(userRegistration.getEmail());

        if (!optionalUserCredentials.isPresent()) {
            String encodedPassword = bCryptPasswordEncoder.encode(userRegistration.getPassword());

            userRegistration.setPassword(encodedPassword);
            UserCredentials userCredentials = UserCredentials.builder()
                    .email(userRegistration.getEmail())
                    .password(encodedPassword)
                    .build();

            UserPersonalInfo userPersonalInfo = UserPersonalInfo.builder()
                    .age(userRegistration.getAge())
                    .firstName(userRegistration.getFirstName())
                    .lastName(userRegistration.getLastName())
                    .email(userRegistration.getEmail())
                    .phoneNumber(userRegistration.getPhoneNumber())
                    .build();
            userRegistrationRepo.save(userRegistration);
            userPersonalInfoRepo.save(userPersonalInfo);
            userCredentialsRepo.save(userCredentials);
            try {
                emailService.send(userPersonalInfo);
            } catch (Exception e) {
                log.error("Error while sending the registration confirmation mail to the user: {}", userPersonalInfo.getFirstName(), e);
            }
            return "registerSuccessful";
        }
        log.info("The user with email: {} is already registered", userRegistration.getEmail());
        return "registration_Fail";
    }

}