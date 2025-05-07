// /src/main/java/com/usermanagement/api/routes/user/UserRoutes.java

package com.usermanagement.api.routes.user;

import org.springframework.stereotype.Component;
import static org.springframework.web.servlet.function.RequestPredicates.DELETE;
import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.PATCH;
import static org.springframework.web.servlet.function.RequestPredicates.POST;
import org.springframework.web.servlet.function.RouterFunction;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import org.springframework.web.servlet.function.ServerResponse;

import com.usermanagement.api.controllers.user.UserController;

@Component
public class UserRoutes {

    private final UserController controller;

    public UserRoutes(UserController controller) {
        this.controller = controller;
    }

    public RouterFunction<ServerResponse> userRouter() {
        return route(POST("/users"), controller::createUserController)
                .andRoute(PATCH("/users/{id}"), controller::updateUserController)
                .andRoute(GET("/users"), controller::getAllUsersController)
                .andRoute(DELETE("/users/{id}"), controller::deleteUserController);
    }
}
