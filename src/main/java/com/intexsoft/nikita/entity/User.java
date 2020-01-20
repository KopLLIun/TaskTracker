package com.intexsoft.nikita.entity;

import jdk.jfr.DataAmount;

@DataAmount
public class User {

    private Long id;

    private String name;

    private String surname;

    private String login;

    private char[] password;

    public User() {
    }
}
