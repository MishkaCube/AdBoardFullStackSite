package com.solarlab.project.configuration;


import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository) {
        return args -> {
            Users michael = new Users("Michael",
                    "michael.gmail.com",
                    12,
                    LocalDate.of(2004, 10, 14));
            Users michaela = new Users("Michaela",
                    "michaela.gmail.com",
                    0,
                    LocalDate.of(2004, 01, 15));
            repository.saveAll(List.of(michael, michaela));

        };
    }

}
