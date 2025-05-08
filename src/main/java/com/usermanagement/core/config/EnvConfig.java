// /src/main/java/com/usermanagement/core/config/EnvConfiguration.java

package com.usermanagement.core.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

    private final String apiName;
    private final String apiLogLevel;
    private final String datasourceUrl;
    private final String datasourceUsername;
    private final String datasourcePassword;
    private final String datasourceDriver;
    private final int serverPort;
    private final String jwtSecret;
    private final long jwtExpirationMs;

    public EnvConfig(Dotenv dotenv) {
        this.apiName = dotenv.get("API_NAME");
        this.apiLogLevel = dotenv.get("API_LOG_LEVEL");
        this.datasourceUrl = dotenv.get("DATASOURCE_URL");
        this.datasourceUsername = dotenv.get("DATABASE_USER");
        this.datasourcePassword = dotenv.get("DATABASE_PASSWORD");
        this.datasourceDriver = dotenv.get("DATABASE_DRIVER");
        this.serverPort = Integer.parseInt(dotenv.get("API_PORT"));

        this.jwtSecret = dotenv.get("JWT_SECRET");
        this.jwtExpirationMs = Long.parseLong(dotenv.get("JWT_EXPIRATION_MS"));

        System.out.println("API Name: " + apiName);
        System.out.println("API Port: " + serverPort);
        System.out.println("API running...");
    }

    public String getApiName() {
        return apiName;
    }

    public String getApiLogLevel() {
        return apiLogLevel;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public String getDatasourceDriver() {
        return datasourceDriver;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public long getJwtExpirationMs() {
        return jwtExpirationMs;
    }
}
