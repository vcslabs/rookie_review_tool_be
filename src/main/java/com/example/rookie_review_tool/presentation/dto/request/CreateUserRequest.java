package com.example.rookie_review_tool.presentation.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {

    private String name;

    private String password;

    private Integer contribution;

    private String bio;
}
