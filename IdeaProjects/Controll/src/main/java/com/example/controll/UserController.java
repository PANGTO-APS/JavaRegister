package com.example.controll;

public class UserController {
    int id;
    String firstname, lastname, username;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public UserController(int id, String firstname, String lastname, String username) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }
}
