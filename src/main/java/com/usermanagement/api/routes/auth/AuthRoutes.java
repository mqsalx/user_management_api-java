// /src/main/java/com/usermanagement/api/routes/auth/AuthRoutes.java

package com.usermanagement.api.routes.auth;

import com.usermanagement.api.controllers.auth.AuthController;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.POST;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Component
public class AuthRoutes {

    private final AuthController controller;

    public AuthRoutes(AuthController controller) {
        this.controller = controller;
    }

    public RouterFunction<ServerResponse> authRouter() {
        return route(POST("/auth"), controller::login);
    }
}