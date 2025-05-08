// /src/main/java/com/usermanagement/services/auth/impl/AuthServiceImpl.java

package com.usermanagement.services.auth.impl;

import com.usermanagement.core.dtos.auth.AuthRequestDTO;
import com.usermanagement.core.dtos.auth.AuthResponseDTO;
import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.infrastructure.repositories.user.IUserRepository;
import com.usermanagement.services.auth.IAuthService;
import com.usermanagement.services.user.utils.UserServiceUtils;
import com.usermanagement.utils.AuthUtil;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements IAuthService {

    private final IUserRepository userRepository;
    private final AuthUtil authUtil;

    public AuthServiceImpl(IUserRepository userRepository, AuthUtil authUtil) {
        this.userRepository = userRepository;
        this.authUtil = authUtil;
    }

    @Override
    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        UserEntity user = userRepository.findUserByEmail(request.getEmail());

        if (user == null || !UserServiceUtils.checkPassword(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials!");
        }

        String token = authUtil.generateToken(user.getId(), user.getEmail());
        return new AuthResponseDTO(token);
    }

}
