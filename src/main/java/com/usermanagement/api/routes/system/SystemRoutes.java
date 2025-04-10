// /src/main/java/com/usermanagement/api/routes/system/SystemRoutes.java

package com.usermanagement.api.routes.system;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class SystemRoutes {

    @Bean
    public RouterFunction<ServerResponse> systemRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/routes"), this::listRoutes);
    }

    private ServerResponse listRoutes(ServerRequest request) {
        List<Map<String, String>> routes = request.attributes().entrySet().stream()
                .filter(e -> e.getKey().contains("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern"))
                .map(e -> Map.of("path", e.getValue().toString(), "method", request.method().name(), "name", "unknown"))
                .collect(Collectors.toList());

        return ServerResponse.ok().body(Map.of("available_routes", routes));
    }
}
