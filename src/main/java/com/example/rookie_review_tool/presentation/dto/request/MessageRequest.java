package com.example.rookie_review_tool.presentation.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageRequest {

    private Integer userId;

    private Integer roomId;

    private String sendingUserName;

    private String detail;
}
