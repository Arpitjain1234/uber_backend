package com.example.uber.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String city;
    private String mobile;
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
}
