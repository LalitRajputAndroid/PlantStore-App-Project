package com.example.plantsstore.Modals;

public class Users {
    private  String Name;
    private String Email;
    private  String Password;
    private String userID;

    public Users() {
    }

    public Users(String name, String email, String password, String userID) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.userID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
