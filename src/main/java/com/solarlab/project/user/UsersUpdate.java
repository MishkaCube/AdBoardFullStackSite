package com.solarlab.project.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersUpdate {

    private String name;
    private String secondName;
    private String email;
    private String password;
}
