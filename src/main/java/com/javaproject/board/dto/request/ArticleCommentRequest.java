package com.javaproject.board.dto.request;

import com.javaproject.board.dto.ArticleCommentDto;
import com.javaproject.board.dto.UserAccountDto;

/**
 * A DTO for the {@link com.javaproject.board.domain.ArticleComment} entity
 */
public record ArticleCommentRequest(Long articleId, String content){

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}