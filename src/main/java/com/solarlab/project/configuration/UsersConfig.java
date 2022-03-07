package com.solarlab.project.configuration;


import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository) {
        return args -> {
            Users michael = new Users("Michael",
                    "michael.gmail.com",
                    12,
                    15);
            Users michaela = new Users("Michaela",
                    "michaela.gmail.com",
                    0,
                    17);
            repository.saveAll(List.of(michael, michaela));

        };
    }

}
