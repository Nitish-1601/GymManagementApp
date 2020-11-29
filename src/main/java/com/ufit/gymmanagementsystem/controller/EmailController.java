package com.ufit.gymmanagementsystem.controller;

import com.ufit.gymmanagementsystem.GymManagementSystemApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/send")
    public void send() throws AddressException, MessagingException, IOException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ufitgym8427@gmail.com");
        message.setTo("n.sharma8427@gmail.com");
        message.setSubject("confirmation");
        message.setText("thanks for register");
        javaMailSender.send(message);
    }
}

