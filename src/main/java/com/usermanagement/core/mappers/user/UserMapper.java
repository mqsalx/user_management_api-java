// /src/main/java/com/usermanagement/core/mappers/user/UserMapper.java

package com.usermanagement.core.mappers.user;

import com.usermanagement.core.dtos.user.UserRequestDTO;
import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.infrastructure.models.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserEntity toEntity(UserRequestDTO dto);

  UserResponseDTO toResponseDTO(UserEntity entity);

  @Mapping(target = "id", ignore = true)
  @org.mapstruct.BeanMapping(
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateUserFromDTO(UserRequestDTO dto, @MappingTarget UserEntity entity);
}
