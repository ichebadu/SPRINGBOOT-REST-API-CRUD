package com.crudapp.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name="first-name" , nullable = false)
    private String firstName;
    @Column (name="first-name", nullable =false)
    private String LastName;
    @Column (name="username", nullable =false)
    private String username;
    @Column (name="email", nullable =false)
    private String Email;
    @Column (name = "password", nullable =false)
    private String password;

}
