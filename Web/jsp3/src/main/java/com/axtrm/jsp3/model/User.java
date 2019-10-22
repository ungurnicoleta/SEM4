package com.axtrm.jsp3.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString(exclude = {"password"})
public class User implements Serializable {

    private int userId;

    private String username;
    private String password;

    private String email;
    private String address;
    private String hometown;

    private int age;

    private String pictureUrl;
}
