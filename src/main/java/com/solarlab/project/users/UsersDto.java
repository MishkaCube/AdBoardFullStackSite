package com.solarlab.project.users;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String role;

}
