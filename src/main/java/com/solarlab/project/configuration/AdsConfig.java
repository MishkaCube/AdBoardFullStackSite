package com.solarlab.project.configuration;


import com.solarlab.project.entity.Advertisments;
import com.solarlab.project.repository.AdsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Configuration
public class AdsConfig {
    @Bean
    CommandLineRunner adsConfigurer(AdsRepository repository) {
        return args -> {
            Advertisments ad1 = new Advertisments(
                    1L,
                    "Title 1",
                    "Text of the ad 1",
                    1000,
                    "Technics",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\Фон.jpg")
            );
            Advertisments ad2 = new Advertisments(
                    2L,
                    "Title 2",
                    "Text of the ad 2",
                    1500,
                    "Household goods",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\picture.jpg")
            );
            Advertisments ad3 = new Advertisments(
                    3L,
                    "Title 3",
                    "Text of the ad 3",
                    2500,
                    "Sport goods",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\Фон.jpg")
            );
            Advertisments ad4 = new Advertisments(
                    4L,
                    "Title 3",
                    "Text of the ad 3",
                    2500,
                    "Sport goods",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\picture.jpg")
            );
            Advertisments ad5 = new Advertisments(
                    5L,
                    "Title 3",
                    "Text of the ad 3",
                    2500,
                    "Sport goods",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\Фон.jpg")
            );
            Advertisments ad6 = new Advertisments(
                    6L,
                    "Title 4",
                    "Text of the ad 4",
                    15000,
                    "Techincs",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\picture.jpg")
            );
            Advertisments ad7 = new Advertisments(
                    7L,
                    "Title 4",
                    "Text of the ad 4",
                    15000,
                    "Techincs",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\picture.jpg")
            );
            Advertisments ad8 = new Advertisments(
                    8L,
                    "Title 4",
                    "Text of the ad 4",
                    15000,
                    "Techincs",
                    extractBytes("C:\\Users\\Mishka\\Desktop\\picture.jpg")
            );
            repository.saveAll(List.of(ad1, ad2, ad3, ad4, ad5, ad6, ad7, ad8));
        };
    }

    public byte[] extractBytes(String urlText) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(urlText));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos);
        byte[] data = bos.toByteArray();
        return data;
    }


}
