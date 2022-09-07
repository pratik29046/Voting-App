package com.app.voting;

public class UserInfo {

    private String username;
    private String Password;
    private String Email;
    private String Phone;

    public UserInfo() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
