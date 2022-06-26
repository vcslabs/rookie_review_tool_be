package com.example.rookie_review_tool.domain.model;

import com.example.rookie_review_tool.infrastructure.dto.response.FindUserResponse;
import com.example.rookie_review_tool.presentation.dto.request.CreateUserRequest;
import com.example.rookie_review_tool.presentation.dto.request.UpdateUserRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Nonnull;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class User {

    private final PasswordEncoder passwordEncoder;

    private Integer id;

    private String name;

    private String password;

    private Integer contribution;

    private String bio;


    public static User from(@Nonnull final FindUserResponse findUserResponse) {

        return User.builder()
                .id(findUserResponse.getId())
                .name(findUserResponse.getName())
                .contribution(findUserResponse.getContribution())
                .bio(findUserResponse.getBio())
                .build();
    }

    public static User from(@Nonnull final CreateUserRequest createUserRequest) {

        return User.builder()
                .password(createUserRequest.getPassword())
                .name(createUserRequest.getName())
                .contribution(createUserRequest.getContribution())
                .bio(createUserRequest.getBio())
                .build();
    }

    public static User from(@Nonnull final UpdateUserRequest updateUserRequest) {

        return User.builder()
                .name(updateUserRequest.getName())
                .password(updateUserRequest.getPassword())
                .contribution(updateUserRequest.getContribution())
                .bio(updateUserRequest.getBio())
                .build();
    }
}
