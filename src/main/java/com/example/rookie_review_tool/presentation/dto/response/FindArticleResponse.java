package com.example.rookie_review_tool.presentation.dto.response;

import com.example.rookie_review_tool.domain.model.Article;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class FindArticleResponse {

    private Integer userId;

    private String tag;

    private String title;

    private String detail;

    public static FindArticleResponse from(@NonNull final Article article) {

        return FindArticleResponse.builder()
                .userId(article.getUserId())
                .tag(article.getTag())
                .title(article.getTitle())
                .detail(article.getDetail())
                .build();
    }
}
