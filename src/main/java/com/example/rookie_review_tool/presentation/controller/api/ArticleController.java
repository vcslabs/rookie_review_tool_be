package com.example.rookie_review_tool.presentation.controller.api;

import com.example.rookie_review_tool.application.service.ArticleService;
import com.example.rookie_review_tool.presentation.dto.request.CreateArticleRequest;
import com.example.rookie_review_tool.presentation.dto.request.UpdateUserRequest;
import com.example.rookie_review_tool.presentation.dto.response.FindArticleResponse;
import com.example.rookie_review_tool.presentation.dto.response.FindUserResponse;
import com.example.rookie_review_tool.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/")
    public int create(@RequestBody final CreateArticleRequest request,
                      @AuthenticationPrincipal final UserDetailsImpl userDetails) {

        return articleService.create(request, userDetails.getUserId());
    }

    @GetMapping("/{searchString}")
    public FindArticleResponse findByString(@PathVariable String searchString) {

        return FindArticleResponse.from(articleService.findByString(searchString));
    }

    @PutMapping("/{id}")
    public int updateUser(@RequestBody final UpdateUserRequest request,
                          @PathVariable final Integer id) {
        // 仮実装
        return 1;
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable final Integer id) {

        // 仮実装
        return 1;
    }
}
