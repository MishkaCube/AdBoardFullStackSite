package com.solarlab.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

}
