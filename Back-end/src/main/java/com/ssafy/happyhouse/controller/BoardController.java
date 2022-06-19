package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dtos.ArticleDto;
import com.ssafy.happyhouse.model.dtos.CommentDto;
import com.ssafy.happyhouse.services.BoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {
	private final String SUCCESS = "SUCCESS";
	private final String FAILURE = "FAILURE";
	
	@Autowired
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//Controller for Boards
	@ApiOperation(value = "게시판 조회", response = List.class)
	@GetMapping("/{boardName}")
	public ResponseEntity<List<ArticleDto>> boardGet(@PathVariable String boardName) throws Exception {
		return new ResponseEntity<List<ArticleDto>>(boardService.getBoard(boardName), HttpStatus.OK);
	}
	
	//Controllers for Articles
	@ApiOperation(value = "게시글 조회", response = ArticleDto.class)
	@GetMapping("/{boardName}/{articleIndex}")
	public ResponseEntity<ArticleDto> articleGet(@PathVariable int articleIndex) throws Exception {
		return new ResponseEntity<ArticleDto>(boardService.readArticle(articleIndex), HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시글 입력", response = String.class)
	@PostMapping("/{boardName}")
	public ResponseEntity<String> articlePost(@PathVariable String boardName, @RequestBody ArticleDto articleDto) throws Exception {
		if (boardService.writeArticle(articleDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시글 수정", response = String.class)
	@PutMapping("/{boardName}/{articleIndex}")
	public ResponseEntity<String> articlePut(@PathVariable int articleIndex, @RequestBody ArticleDto articleDto) throws Exception {
		if (boardService.modifyArticle(articleIndex, articleDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시글 삭제", response = String.class)
	@DeleteMapping("/{boardName}/{articleIndex}")
	public ResponseEntity<String> articleDelete(@PathVariable int articleIndex) throws Exception {
		if (boardService.deleteArticle(articleIndex)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
	
	//Controllers for Comments
	@ApiOperation(value = "댓글 조회", response = CommentDto.class)
	@GetMapping("/{boardName}/{articleIndex}/comments")
	public ResponseEntity<List<CommentDto>> commentGet(@PathVariable int articleIndex) throws Exception {
		return new ResponseEntity<List<CommentDto>>(boardService.getComments(articleIndex), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 입력", response = String.class)
	@PostMapping("/{boardName}/{articleIndex}")
	public ResponseEntity<String> commentPost(@PathVariable int articleIndex, @RequestBody CommentDto commentDto) throws Exception {
		if (boardService.writeComment(commentDto, articleIndex)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 수정", response = String.class)
	@PutMapping("/{boardName}/{articleIndex}/{commentIndex}")
	public ResponseEntity<String> commentPut(@PathVariable int commentIndex, @RequestBody CommentDto commentDto) throws Exception {
		if (boardService.modifyComment(commentIndex, commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 삭제", response = String.class)
	@DeleteMapping("/{boardName}/{articleIndex}/{commentIndex}")
	public ResponseEntity<String> commentDelete(@PathVariable int commentIndex) throws Exception {
		if (boardService.deleteComment(commentIndex)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
}