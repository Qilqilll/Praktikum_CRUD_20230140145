package com.deploy.praktikum1.mapper;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto toUserDtoData (User user);
}