package com.example.rookie_review_tool.application.service;

import com.example.rookie_review_tool.domain.model.User;
import com.example.rookie_review_tool.infrastructure.mapper.UserMapper;
import com.example.rookie_review_tool.presentation.dto.request.CreateUserRequest;
import com.example.rookie_review_tool.presentation.dto.request.UpdateUserRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public User findByName(@NonNull final String name) {

        return User.from(userMapper.findByName(name));
    }

    public int createUser(@NonNull final CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.createUser(User.from(request));
    }

    public int updateUser(@NonNull final UpdateUserRequest request,
                          @NonNull final Integer id) {
        if (Objects.nonNull(request.getPassword())) {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        return userMapper.updateUser(User.from(request), id);
    }

    public int deleteUser(@NonNull final Integer id) {

        return userMapper.deleteUser(id);
    }
}
