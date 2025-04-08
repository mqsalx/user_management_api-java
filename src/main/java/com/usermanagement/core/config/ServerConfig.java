// /src/main/java/com/usermanagement/core/config/ServerConfig.java

package com.usermanagement.core.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig
    implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

  private final EnvConfig envConfig;

  public ServerConfig(EnvConfig envConfig) {
    this.envConfig = envConfig;
  }

  @Override
  public void customize(ConfigurableServletWebServerFactory factory) {
    factory.setPort(envConfig.getServerPort());
  }
}
