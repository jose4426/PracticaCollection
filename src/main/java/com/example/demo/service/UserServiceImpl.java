package com.example.demo.service;

import com.example.demo.domains.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> findAll() {
        List<User> users = repository.findAll();

        List<UserResponse> responses = mapper.entityToResponseList(users);
        /*return users.stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());*/
        return responses;
    }

    @Override
    public UserResponse findById(Long id) {
        existsById(id);
        return mapper.entityToResponse(repository.findById(id).get());
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest request) {
        if (Objects.nonNull(request)) {
            User user = repository.save(mapper.requestToEntity(request));

            return mapper.entityToResponse(user);

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponse update(UserRequest request) {
        if (request.getId() != null) {
            return save(request);
        }
        return null;
    }

    @Override
    public List<UserResponse>search(String name, Long age, String email) {
        Specification<User> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(UserSpecifications.nameLike(name));
        }

        if (age != null) {
            spec = spec.and(UserSpecifications.ageEqual(age));
        }

        if (email != null && email.isEmpty()) {
            spec = spec.and(UserSpecifications.emailEqual(email));
        }
        return  mapper.entityToResponseList(repository.findAll(spec));
    }

    public void existsById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Error");
        }
    }



}
