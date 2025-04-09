// /src/main/java/com/usermanagement/core/config/EnvConfiguration.java

package com.usermanagement.core.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

  private final String appName;
  private final String datasourceUrl;
  private final String datasourceUsername;
  private final String datasourcePassword;
  private final String datasourceDriver;
  private final int serverPort;

  public EnvConfig(Dotenv dotenv) {
    this.appName = dotenv.get("API_NAME");
    this.datasourceUrl = dotenv.get("DATASOURCE_URL");
    this.datasourceUsername = dotenv.get("DATABASE_USER");
    this.datasourcePassword = dotenv.get("DATABASE_PASSWORD");
    this.datasourceDriver = dotenv.get("DATABASE_DRIVER");
    this.serverPort = Integer.parseInt(dotenv.get("API_PORT"));

    System.out.println("App Name: " + appName);
    System.out.println("Server Port: " + serverPort);
  }

  public String getAppName() {
    return appName;
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
}
