// /src/main/java/com/usermanagement/infrastructure/repositories/config/DataSourceConfig.java

package com.usermanagement.infrastructure.repositories.config;

import com.usermanagement.core.config.EnvConfig;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    private final EnvConfig envConfig;

    public DataSourceConfig(EnvConfig envConfig) {
        this.envConfig = envConfig;
    }

    @Bean
    public DataSource dataSource() {

        String url = envConfig.getDatasourceUrl();
        String username = envConfig.getDatasourceUsername();
        String password = envConfig.getDatasourcePassword();
        String driverClassName = envConfig.getDatasourceDriver();

        return DataSourceBuilder.create().url(url).username(username).password(password)
                .driverClassName(driverClassName).build();
    }
}
