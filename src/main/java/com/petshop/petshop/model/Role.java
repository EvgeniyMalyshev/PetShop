package com.petshop.petshop.model;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@XmlRootElement(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToMany (mappedBy = "roles")
//    @ManyToMany
//    @JoinTable (name = "user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

//    public Role() {
//    }
}

