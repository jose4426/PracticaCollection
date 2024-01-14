package com.example.demo.mapper;

import com.example.demo.domains.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",
        uses = {

        })
public interface UserMapper {
    UserResponse entityToResponse(User user);

    User requestToEntity(UserRequest request);

    List<UserResponse> entityToResponseList(List<User> user);

    // UserResponse entityToResponses(List<User> all);
}
