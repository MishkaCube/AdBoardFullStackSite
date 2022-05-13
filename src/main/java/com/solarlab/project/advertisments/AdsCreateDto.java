package com.solarlab.project.advertisments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AdsCreateDto {

    private String title;
    private String text;
    private int price;
    private String category;
    private byte[] src;


}


