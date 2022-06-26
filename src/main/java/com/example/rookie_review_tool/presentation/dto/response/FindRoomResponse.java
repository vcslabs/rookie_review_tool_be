package com.example.rookie_review_tool.presentation.dto.response;

import com.example.rookie_review_tool.domain.model.Room;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class FindRoomResponse {

    private Integer id;

    private String name;

    private Integer ownerId;

    public static FindRoomResponse from(@NonNull final Room room) {

        return FindRoomResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .ownerId(room.getOwnerId())
                .build();
    }
}
