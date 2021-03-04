package com.ufit.gymmanagementsystem.model; 


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_registration")
public class UserRegistration {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int age;
    private String phoneNumber;
}
