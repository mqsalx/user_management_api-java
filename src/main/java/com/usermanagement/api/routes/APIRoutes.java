// /src/main/java/com/usermanagement/api/routes/APIRoutes.java

package com.usermanagement.api.routes;

import com.usermanagement.api.routes.system.SystemRoutes;
import com.usermanagement.api.routes.user.UserRoutes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class APIRoutes {

  @Bean
  public RouterFunction<ServerResponse> mainRouter(
      UserRoutes userRoutes, SystemRoutes systemRoutes) {
    return RouterFunctions.nest(
        RequestPredicates.path("/api"), userRoutes.userRouter().and(systemRoutes.systemRouter()));
  }
}
