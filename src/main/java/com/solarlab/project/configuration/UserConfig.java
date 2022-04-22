package com.solarlab.project.configuration;

import com.solarlab.project.entity.User;
import com.solarlab.project.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner userConfigurer(UsersRepository usersRepository) {
        return args -> {
            User mishka = new User(
                    1L,
                    "username",
                    "mishka",
                    "tsibrankov",
                    "@mail.ru",
                    LocalDate.of(2000, 12, 14),
                    "password",
                    14);
            User anton = new User(
                    2L, "anton_2",
                    "anton",
                    "peresunko",
                    "@mail.ru",
                    LocalDate.of(2000, 12, 14),
                    "password",
                    14);
            User oleg = new User(
                    3L,
                    "oleg_4",
                    "oleg",
                    "michailov",
                    "@mail.ru",
                    LocalDate.of(2000, 12, 14),
                    "password",
                    14);
            usersRepository.saveAll(List.of(mishka, anton, oleg));
        };
    }
}
