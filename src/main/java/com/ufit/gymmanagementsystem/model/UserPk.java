package com.ufit.gymmanagementsystem.model;

import java.io.Serializable;


public class UserPk implements Serializable {
    private String email;

    public UserPk() {

    }

    public UserPk(String email) {
        this.email = email;
    }
}
