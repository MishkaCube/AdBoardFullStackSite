package com.solarlab.project.advertisments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto {

    private Long id;
    private String title;
    private String text;
    private int email;
    private String category;
    private Byte[] src;

}
