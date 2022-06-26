package com.example.rookie_review_tool.presentation.controller.api;

import com.example.rookie_review_tool.application.service.RoomService;
import com.example.rookie_review_tool.presentation.dto.request.CreateRoomRequest;
import com.example.rookie_review_tool.presentation.dto.request.UpdateUserRequest;
import com.example.rookie_review_tool.presentation.dto.response.FindArticleResponse;
import com.example.rookie_review_tool.presentation.dto.response.FindRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    // TODO 仮実装
    @PostMapping("/")
    public int create(@RequestBody final CreateRoomRequest request) {

        return 1;
    }

    @GetMapping("/{roomName}")
    public FindRoomResponse findByName(@PathVariable String roomName) {

        return FindRoomResponse.from(roomService.findByName(roomName));
    }

    // TODO 仮実装
    @PutMapping("/{id}")
    public int update(@RequestBody final UpdateUserRequest request,
                          @PathVariable final Integer id) {
        // 仮実装
        return 1;
    }

    // TODO 仮実装
    @DeleteMapping("/{id}")
    public int delete(@PathVariable final Integer id) {

        // 仮実装
        return 1;
    }
}
