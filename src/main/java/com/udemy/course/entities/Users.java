package com.udemy.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Seria... para trafegar os dados

@Entity
@Table(name = "tb_user")
public class Users implements Serializable {
    private static final  long serialVersionUID = 1l;


  // 1 - Passo //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //Associações em lista: Pq um cliente pode ter varios pedidos

    //Um usuario pode ter varios pedidos.
    //Quando temos uma associação para muitos, devemos utilizar o jsonignore para não estourar a memoria
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    //Faço o get dessa lista coleção
    public List<Order> getOrders() {
        return orders;
    }
//Construtores

    public Users(){

    }

    public Users(Long id, String name, String email, String phone, String password) {
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
