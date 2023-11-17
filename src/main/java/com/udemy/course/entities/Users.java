package com.udemy.course.entities;

import java.io.Serializable;
import java.util.Objects;

//Seria... para trafegar os dados

public class Users implements Serializable {


  // 1 - Passo //Atributos
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //Construtores

    public Users(){

    }

    public Users(long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    //Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
