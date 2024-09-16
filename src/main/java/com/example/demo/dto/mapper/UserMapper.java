package com.example.demo.dto.mapper;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    public static User toDto(UserCreateDTO dto) {
        return new ModelMapper().map(dto, User.class);
    }

    public static UserResponseDTO toUser(User user) {
        return new ModelMapper().map(user,UserResponseDTO.class);
    }
}
