package com.example.rookie_review_tool.infrastructure.mapper;

import com.example.rookie_review_tool.domain.model.Room;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {

    Room findByName(@NonNull final String roomName);
}
