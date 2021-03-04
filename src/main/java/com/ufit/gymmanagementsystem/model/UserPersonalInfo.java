package com.ufit.gymmanagementsystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_personal_info")
public class UserPersonalInfo {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
}
