package com.example.webshop.mappers;

import com.example.webshop.model.User;
import com.example.webshop.model.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements MapperInterface<User, UserDTO> {

    @Override
    public User toEntity(UserDTO dto) {
        return new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getFirstName(), dto.getLastName());
    }

    @Override
    public UserDTO toDTO(User entity) {
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getFirstName(), entity.getLastName());
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtos) {
        List<User> toReturn = new ArrayList<>();
        for(UserDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entities) {
        List<UserDTO> toReturn = new ArrayList<>();
        for(User user : entities) {
            toReturn.add(this.toDTO(user));
        }
        return toReturn;
    }
}
