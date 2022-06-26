package com.example.rookie_review_tool.application.service;

import com.example.rookie_review_tool.domain.model.Article;
import com.example.rookie_review_tool.infrastructure.mapper.ArticleMapper;
import com.example.rookie_review_tool.presentation.dto.request.CreateArticleRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;

    public int create(@NonNull final CreateArticleRequest request,
                      @NonNull final Integer userId) {

        return articleMapper.create(Article.from(request, userId));
    }

    public Article findByString(@NonNull final String searchString) {

        return articleMapper.findByString(searchString);
    }
}
