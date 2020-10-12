package com.ufit.gymmanagementsystem.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
public class UserPk implements Serializable {
    private String id;


    public UserPk(){

    }
    public UserPk(String s) {
        this.id = s;
    }
}
