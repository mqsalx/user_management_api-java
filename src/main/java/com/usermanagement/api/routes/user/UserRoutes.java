// /src/main/java/com/usermanagement/api/routes/user/UserRoutes.java

package com.usermanagement.api.routes.user;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.PATCH;
import static org.springframework.web.servlet.function.RequestPredicates.POST;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import com.usermanagement.api.controllers.user.UserController;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class UserRoutes {

    private final UserController controller;

    public UserRoutes(UserController controller) {
        this.controller = controller;
    }

    public RouterFunction<ServerResponse> userRouter() {
        return route(POST("/users"), controller::createUserController)
                .andRoute(PATCH("/users/{id}"), controller::updateUserController)
                .andRoute(GET("/users"), controller::getAllUsersController);
    }
}
