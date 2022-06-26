package com.example.rookie_review_tool.infrastructure.mapper;

import com.example.rookie_review_tool.domain.model.User;
import com.example.rookie_review_tool.infrastructure.dto.response.FindUserResponse;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    FindUserResponse findByName(@NonNull final String name);

    int createUser(@NonNull final User createUser);

    int updateUser(@NonNull final User user, @NonNull final Integer id);

    int deleteUser(@NonNull final Integer id);
}
