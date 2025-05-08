// /src/main/java/com/usermanagement/UserManagementApplication.java

package com.usermanagement;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Logging configuration
        System.setProperty("logging.level.root", dotenv.get("API_LOGGING_LEVEL_ROOT", "INFO"));
        System.setProperty("logging.level.org.springframework",
                dotenv.get("API_LOGGING_LEVEL_ORG_SPRINGFRAMEWORK", "INFO"));
        System.setProperty("logging.level.org.hibernate", dotenv.get("API_LOGGING_LEVEL_ORG_HIBERNATE", "INFO"));

        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().ignoreIfMissing().load();
    }
}
