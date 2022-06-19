package com.ssafy.happyhouse.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dtos.ArticleDto;
import com.ssafy.happyhouse.model.dtos.CommentDto;
import com.ssafy.happyhouse.model.mapper.IBoardMapper;

@Service
public class BoardService {
	
	@Autowired
	IBoardMapper boardMapper;
	
	// Service for Boards
	public List<ArticleDto> getBoard(String boardName) {
		return boardMapper.selectArticleByBoard(boardName);
	}

	// Services for Articles
	public ArticleDto readArticle(int articleIndex) {
		return boardMapper.selectArticle(articleIndex);
	}
	
	public boolean writeArticle(ArticleDto articleDto) {
		articleDto.setTime(new Date());
		return boardMapper.insertArticle(articleDto) == 1;
	}
	
	public boolean modifyArticle(int articleIndex, ArticleDto articleDto) {
		return boardMapper.updateArticle(articleIndex, articleDto) == 1;
	}
	
	public boolean deleteArticle(int articleIndex) {
		return boardMapper.deleteArticle(articleIndex) == 1;
	}
	
	// Services for Comments
	public List<CommentDto> getComments(int articleIndex) {
		return boardMapper.selectCommentsByArticle(articleIndex);
	}
	
	public boolean writeComment(CommentDto commentDto, int articleIndex) {
		commentDto.setTime(new Date());
		commentDto.setArticleIndex(articleIndex);
		return boardMapper.insertComment(commentDto) == 1;
	}
	
	public boolean modifyComment(int commentIndex, CommentDto commentDto) {
		return boardMapper.updateComment(commentIndex, commentDto) == 1;
	}
	
	public boolean deleteComment(int commentIndex) {
		return boardMapper.deleteComment(commentIndex) == 1;
	}
}
