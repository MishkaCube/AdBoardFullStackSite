package com.solarlab.project.users;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersDto {

    private UUID id;
    private String username;
    private String password;
    private String email;

}
