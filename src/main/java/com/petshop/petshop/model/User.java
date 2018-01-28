package com.petshop.petshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "usernamename")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Transient
    private String passwordConfirm;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }







}
