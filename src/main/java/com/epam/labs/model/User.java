package com.epam.labs.model;

import com.univocity.parsers.annotations.Parsed;

public class User {

    @Parsed(field = "email")
    private String email;

    @Parsed(field = "pass")
    private String password;

    public User() {
    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
