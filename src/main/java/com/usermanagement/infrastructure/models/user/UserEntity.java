// /src/main/java/com/usermanagement/infrastructure/models/user/UserEntity.java

package com.usermanagement.infrastructure.models.user;

import com.usermanagement.services.utils.ServiceUtils;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @PrePersist
  public void prePersist() {
    if (this.id == null || this.id.isEmpty()) {
      this.id = ServiceUtils.generateUniqueId();
    }
  }
}
