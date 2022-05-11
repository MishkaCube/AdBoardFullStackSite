//package com.solarlab.project.configuration;
//
//
//import com.solarlab.project.entity.Advertisment;
//import com.solarlab.project.repository.AdsRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//
//
//@Configuration
//public class AdsConfig {
//    @Bean
//    CommandLineRunner adsConfigurer(AdsRepository repository) {
//        return args -> {
//            Advertisment ad1 = new Advertisment(
//                    1L,
//                    "Title 1",
//                    "",
//                    "Text of the ad 1",
//                    1000,
//                    "Technics",
//                    extractBytes("C:\\Users\\Mishka\\Desktop\\Фон.jpg")
//            );
//            Advertisment ad2 = new Advertisment(
//                    2L,
//                    "Title 1",
//                    "",
//                    "Text of the ad 1",
//                    1000,
//                    "Technics",
//                    extractBytes("C:\\Users\\Mishka\\Desktop\\Фон.jpg")
//            );
//            repository.saveAll(List.of(ad1, ad2));
//        };
//    }
//
//    public byte[] extractBytes(String urlText) throws IOException {
//        BufferedImage bImage = ImageIO.read(new File(urlText));
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ImageIO.write(bImage, "jpg", bos);
//        byte[] data = bos.toByteArray();
//        return data;
//    }
//
//
//}
