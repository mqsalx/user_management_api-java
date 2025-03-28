// /src/main/java/com/usermanagement/infrastructure/models/user/UserEntity.java

package com.usermanagement.infrastructure.models.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  private String password;
}
