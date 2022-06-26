package com.example.rookie_review_tool.domain.model;

import com.example.rookie_review_tool.presentation.dto.request.CreateArticleRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class Article {

    private Integer id;

    private Integer userId;

    private String tag;

    private String title;

    private String detail;

    public static Article from(@NonNull final CreateArticleRequest request,
                               @NonNull final Integer userId) {

        return Article.builder()
                .userId(userId)
                .tag(request.getTag())
                .title(request.getTitle())
                .detail(request.getDetail())
                .build();
    }
}
