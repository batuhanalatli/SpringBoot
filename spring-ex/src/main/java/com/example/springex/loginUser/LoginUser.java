package com.example.springex.loginUser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Objects;


@Entity
public class LoginUser {

    @Id
    private int id;
    private String userName;
    private String password;

    public LoginUser(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public LoginUser() {

    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return id == loginUser.id && Objects.equals(userName, loginUser.userName) && Objects.equals(password, loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password);
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
