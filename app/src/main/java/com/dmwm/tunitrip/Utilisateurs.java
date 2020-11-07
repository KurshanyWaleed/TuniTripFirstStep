package com.dmwm.tunitrip;

public class Utilisateurs {

    private   String Username;
    private String Password;
    private String Email;

    public Utilisateurs() {

    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsername(String username) {
        this.Username = username;
    }



    public void setPassword(String password) {
       this.Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

