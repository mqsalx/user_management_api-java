// /src/main/java/com/usermanagement/services/auth/IAuthService.java

package com.usermanagement.services.auth;

import com.usermanagement.core.dtos.auth.AuthRequestDTO;
import com.usermanagement.core.dtos.auth.AuthResponseDTO;

public interface IAuthService {

    AuthResponseDTO authenticate(AuthRequestDTO request);
}
