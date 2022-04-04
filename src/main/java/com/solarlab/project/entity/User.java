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
@Table(name = "Users")
public class User {
    @Column(name = "ID")
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
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


    //private boolean enabled = true;

}
