package com.solarlab.project.advertisments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
public class AdsCreateDto {

    private String name;
    private String secondName;
    private String password;
    private LocalDate dob;

}
