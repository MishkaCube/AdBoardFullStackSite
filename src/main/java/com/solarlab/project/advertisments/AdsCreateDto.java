package com.solarlab.project.advertisments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

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


