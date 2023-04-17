package com.javaproject.board.service;

import com.javaproject.board.dto.ArticleCommentDto;
import com.javaproject.board.repository.ArticleCommentRepository;
import com.javaproject.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticlesComment(long articleId) {
        return List.of();
    }
}
