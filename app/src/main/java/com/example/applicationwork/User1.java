package com.example.applicationwork;

public class User1 {
    private int id;
    private String username;
    private String password;
    private String nicheng;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nicheng='" + nicheng + '\'' +
                '}';
    }
}
