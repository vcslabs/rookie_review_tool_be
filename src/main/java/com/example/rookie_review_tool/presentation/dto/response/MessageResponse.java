package com.example.rookie_review_tool.presentation.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class MessageResponse {

    private String sendingUserName;

    private String detail;

    public static MessageResponse of(@NonNull final String sendingUserName, @NonNull final String detail) {

        return MessageResponse.builder()
                .sendingUserName(sendingUserName)
                .detail(detail)
                .build();
    }

}
