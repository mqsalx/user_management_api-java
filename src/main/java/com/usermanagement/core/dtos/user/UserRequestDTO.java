package com.usermanagement.core.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    private String id;
    private String name;
    private String email;
    private String password;
}
