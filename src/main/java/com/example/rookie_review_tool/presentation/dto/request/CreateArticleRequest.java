package com.example.rookie_review_tool.presentation.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateArticleRequest {

    private String tag;

    private String title;

    private String detail;
}
