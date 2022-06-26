package com.example.rookie_review_tool.application.service;

import com.example.rookie_review_tool.domain.model.Room;
import com.example.rookie_review_tool.infrastructure.mapper.RoomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomMapper roomMapper;

    public Room findByName(@NonNull final String roomName) {

        return roomMapper.findByName(roomName);
    }
}
