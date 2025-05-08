// /src/main/java/com/usermanagement/core/dtos/auth/AuthRequestDTO.java

package com.usermanagement.core.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequestDTO {
    private String email;
    private String password;
}
