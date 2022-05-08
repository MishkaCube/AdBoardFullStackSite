package com.solarlab.project.advertisments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateAds {

    private Long id;
    private String title;
    private String text;
    private String email;
    private String category;
}
