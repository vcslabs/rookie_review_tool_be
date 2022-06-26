package com.example.rookie_review_tool.infrastructure.mapper;

import com.example.rookie_review_tool.domain.model.Article;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    int create(@NonNull final Article article);

    Article findByString(@NonNull final String searchString);
}
