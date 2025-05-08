// /src/main/java/com/usermanagement/core/dtos/auth/AuthResponseDTO.java

package com.usermanagement.core.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "bearer";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
