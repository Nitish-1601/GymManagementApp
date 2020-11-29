package com.ufit.gymmanagementsystem.service;

import com.ufit.gymmanagementsystem.model.UserPersonalInfo;
import com.ufit.gymmanagementsystem.repo.UserPersonalInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserPersonalInfoRepo userPersonalInfoRepo;

    public void send(UserPersonalInfo userPersonalInfo) throws AddressException, MessagingException, IOException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ufitgym8427@gmail.com");
        message.setTo(userPersonalInfo.getEmail());
        message.setSubject("Registration Confirm");
        message.setText("Welcome " + userPersonalInfo.getFirstName() + " We’re excited you’ve joined U-fit");
        javaMailSender.send(message);
    }
}
