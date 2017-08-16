package com.vault.test;

import org.springframework.stereotype.Component;

/**
 * Created by avijit on 8/7/2017.
 */
public class Secrets {

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
