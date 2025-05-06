# 👨🏽‍💻 user_management_api

## 📜 Project Description

- ### Is a project under development, created with the aim of offering a robust and scalable solution for user management and system authentication. Developed using Spring Boot as its main framework, this API adopts Clean Architecture principles to ensure modularity, simplified maintenance and easy expansion.

## 📂 Project Structure
- ### The project is organized into several key directories and files, each serving a specific purpose. Below is a brief overview of the structure:
    ```plaintext
        user_management_api/
        ┃
        ┣ .mvn                                          # Maven wrapper configuration folder
        ┃ ┃
        ┃ ┗ wrapper                                     # Contains Maven wrapper scripts and properties
        ┃   ┃
        ┃   ┗ maven-wrapper.properties                  # Specifies Maven version and wrapper settings
        ┃
        ┣ config                                        # External configuration files (e.g., formatting rules)
        ┃ ┃
        ┃ ┗ formatter.xml                               # Code formatting rules for the project
        ┃
        ┣ src                                           # Source code directory
        ┃ ┃
        ┃ ┣ main                                        # Main application code
        ┃ ┃ ┃
        ┃ ┃ ┣ java                                      # Java source files
        ┃ ┃ ┃ ┃
        ┃ ┃ ┃ ┗ com                                     # Base package
        ┃ ┃ ┃   ┃
        ┃ ┃ ┃   ┗ usermanagement                        # Root package of the project
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ api                                 # API layer
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ controllers                       # Controllers that handle requests and responses
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┗ routes                            # Route definitions and endpoint grouping
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ core                                # Core components of the application
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ config                            # Configuration classes (e.g., environment, beans)
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ dtos                              # Data Transfer Objects used for input/output
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ enums                             # Enum definitions (e.g., user roles, statuses)
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ exceptions                        # Custom exception classes
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ mappers                           # Mapper interfaces/classes (e.g., MapStruct)
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┗ middlewares                       # Middleware components (e.g., interceptors, filters)
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ infrastructure                      # Infrastructure layer
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┣ models                            # Entity and model definitions (e.g., JPA entities)
        ┃ ┃ ┃     ┃ ┃
        ┃ ┃ ┃     ┃ ┗ repositories                      # Database access layer (e.g., JPA repositories)
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ services                            # Business logic and service classes
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ utils                               # Utility/helper classes
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ checkstyle-suppressions.xml         # File to suppress certain Checkstyle rules
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┣ package-info.java                   # Package-level JavaDoc and annotations
        ┃ ┃ ┃     ┃
        ┃ ┃ ┃     ┗ UserManagementApplication.java      # Main Spring Boot application entry point
        ┃ ┃ ┃
        ┃ ┃ ┗ resources                                 # Resources (application.properties, static files, etc.)
        ┃ ┃
        ┃ ┗ test                                        # Unit and integration test classes
        ┃
        ┣ .env_example                                  # Example environment variables file
        ┃
        ┣ .gitattributes                                # Git attributes for line endings and diff settings
        ┃
        ┣ .gitignore                                    # Specifies files and folders to ignore in Git
        ┃
        ┣ mvnw                                          # Unix-based script to run Maven without installing it
        ┃
        ┣ mvnw.cmd                                      # Windows-based script to run Maven without installing it
        ┃
        ┣ pom.xml                                       # Maven project file with dependencies and build configuration
        ┃
        ┗ README.md                                     # Project overview, instructions, and documentation

    ```

## 🎛️ Features
- **User Management**: Create, update, list, and delete users with basic information.
- **JWT authentication**: Secures access to routes, ensuring that only authenticated users can perform operations.

## 🛠️ Technologies Used
- **Java (`21.0.5 2024-10-15 LTS`)**: Programming language used for development.
- **Spring Boot**: Framework used to build the RESTful API with minimal configuration and high scalability.
- **Spring Web**: For building RESTful web services and handling HTTP requests.
- **Spring Security**: Used to implement authentication and authorization mechanisms.
- **JWT (JSON Web Token)**: Ensures secure, stateless authentication.
- **Spring Data JPA**: Simplifies database access and ORM integration.
- **PostgreSQL**: Relational databases supported (depending on environment configuration).
- **Swagger (Springdoc OpenAPI)**: Generates and displays interactive API documentation.
- **MapStruct**: Used for automatic mapping between DTOs and entities.
- **Lombok**: Reduces boilerplate code by generating getters, setters, constructors, etc.
- **Maven**: Build automation tool used for project dependency management and packaging.

## 🤹🏽‍♂️ Dependencies
- ### To check the dependencies and their details consult the file [**pom.xml**](./pom.xml).

## ▶️ Environment
- ### 👨🏽‍⚖️ Formatting
    ```bash
    mvn spotless:apply
    ```
- ### 🧹 Build the project
    ```bash
    mvn clean package
    ```
- ## ✅ Running
    ```bash
    java -jar target/usermanagement-0.0.1-SNAPSHOT.jar
    ```
