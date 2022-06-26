package com.example.rookie_review_tool.presentation.dto.response;

import com.example.rookie_review_tool.domain.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class FindUserResponse {

    private Integer id;

    private String name;

    private Integer contribution;

    private String bio;

    public static FindUserResponse from(User user) {

        return FindUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .contribution(user.getContribution())
                .bio(user.getBio())
                .build();
    }
}
