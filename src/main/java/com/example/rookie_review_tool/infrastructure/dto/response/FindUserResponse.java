package com.example.rookie_review_tool.infrastructure.dto.response;

import lombok.Getter;

@Getter
public class FindUserResponse {

    private Integer id;

    private String name;

    private String password;

    private Integer contribution;

    private String bio;

}
