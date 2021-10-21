package com.oles.spring.model;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name="role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    private Status status;

    public User(String email, String firstName, String lastName, String password, Role role, Status status) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User() {
    }
}
