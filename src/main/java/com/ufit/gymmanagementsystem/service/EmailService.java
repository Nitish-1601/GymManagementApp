//package com.ufit.gymmanagementsystem.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendEmail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("ufitgym8427@gmail.com");
//        message.setTo("n.sharma8427@gmail.com");
//        message.setSubject("no reply");
//        message.setText("thanks for register");
//        javaMailSender.send(message);
//        System.out.println("email sent");
//    }
//
//}
