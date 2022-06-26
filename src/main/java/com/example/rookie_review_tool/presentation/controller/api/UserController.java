package com.example.rookie_review_tool.presentation.controller.api;

import com.example.rookie_review_tool.application.service.UserService;
import com.example.rookie_review_tool.presentation.dto.request.CreateUserRequest;
import com.example.rookie_review_tool.presentation.dto.request.UpdateUserRequest;
import com.example.rookie_review_tool.presentation.dto.response.FindUserResponse;
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
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public int createUser(@RequestBody final CreateUserRequest request) {

        return userService.createUser(request);
    }

    @GetMapping("/{name}")
    public FindUserResponse findByName(@PathVariable String name) {

        return FindUserResponse.from(userService.findByName(name));
    }

    @PutMapping("/{id}")
    public int updateUser(@RequestBody final UpdateUserRequest request,
                          @PathVariable final Integer id) {

        return userService.updateUser(request, id);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable final Integer id) {

        return userService.deleteUser(id);
    }

    @GetMapping("/hello")
    public String hello() {

        return "ログイン成功";
    }
}
