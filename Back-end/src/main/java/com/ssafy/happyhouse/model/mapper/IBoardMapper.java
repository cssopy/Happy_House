package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dtos.ArticleDto;
import com.ssafy.happyhouse.model.dtos.CommentDto;

@Mapper
public interface IBoardMapper {
	int deleteArticle(int index);
	
	int deleteComment(int index);
	
	int insertArticle(ArticleDto articleDto);
	
	int insertComment(CommentDto commentDto);
	
	ArticleDto selectArticle(int index);
	
	List<ArticleDto> selectArticleByBoard(String board);
	
	List<CommentDto> selectCommentsByArticle(int articleIndex);
	
	int updateArticle(@Param("index") int index, @Param("articleDto") ArticleDto articleDto);
	
	int updateComment(@Param("index") int index, @Param("commentDto") CommentDto commentDto);
}