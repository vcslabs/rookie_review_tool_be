package com.example.rookie_review_tool.presentation.dto.request;

import lombok.Data;

@Data
public class CreateRoomRequest {

    private String name;

    private Integer ownerId;
}
