package com.example.demo.service;

import com.example.demo.domains.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> findAll() {
        List<User> users= repository.findAll();

        return users.stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {

        return  mapper.entityToResponse(repository.findById(id).get());
    }

    @Override
    public UserResponse save(UserRequest request) {
        return mapper.entityToResponse(repository.save( mapper.requestToEntity(request)));

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponse update(UserRequest request) {
        return null;
    }

    public void existsById(Long id) {
        if (!repository.existsById(id)) {

        }
    }
}
