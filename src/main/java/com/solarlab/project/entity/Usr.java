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
@Table(name = "usr")
public class Usr {
    @Column(name = "ID")
    @Id
    private Long id;

    /** Логин */
    private String username;

    /** Пароль */
    private String password;

    /** Электронная почта */
    private String email;

    /** Пользователь активный или нет */
    private boolean enabled = true;

//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "second_name")
//    private String secondName;
//
//    @Column(name = "user_email")
//    private String email;
//
//    @Column(name = "date_of_birth")
//    private LocalDate dob;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "age")
//    private int age;

}
