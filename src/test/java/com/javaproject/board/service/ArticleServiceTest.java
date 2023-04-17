package com.javaproject.board.service;

import com.javaproject.board.dto.ArticleDto;
import com.javaproject.board.domain.Article;
import com.javaproject.board.domain.type.SearchType;
import com.javaproject.board.dto.ArticleUpdateDto;
import com.javaproject.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    /*
        검색
        각 게시글 페이지로 이동
        페이지 네이션
        홈 버튼 -> 게시판 페이지로 리다이렉션
        정렬 기능
     */

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenNoSearchParameters_whenSearchingArticles_thenReturnsArticlePage() {
        // Given


        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given


        // When
        ArticleDto articles = sut.searchArticles(1L);

        // Then
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글 정보를 입력하면, 게시물을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle(){
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "Hyunwoo", "title","content","#해시태그"));

        // Then
        then(articleRepository).should().save(any(Article.class));


    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시물을 수정한다")
    @Test
    void givenModifiedArticleInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content","#해시태그"));

        // Then
        then(articleRepository).should().save(any(Article.class));


    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);

        // Then
        then(articleRepository).should().save(any(Article.class));



    }

}