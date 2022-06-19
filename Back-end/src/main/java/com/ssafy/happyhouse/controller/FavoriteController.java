package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dtos.FavAddressDto;
import com.ssafy.happyhouse.model.dtos.FavoriteDto;
import com.ssafy.happyhouse.services.FavoriteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	private final String SUCCESS = "SUCCESS";
	private final String FAILURE = "FAILURE";

	@Autowired
	private final FavoriteService favoriteService;

	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}

	@ApiOperation(value = "즐겨찾기 등록", response = String.class)
	@PostMapping("/register")
	public ResponseEntity<String> registerPost(@RequestBody @ApiParam(value = "지역 정보", required = true) FavAddressDto favAddressDto)
			throws Exception {
		if (favoriteService.registerFavorite(favAddressDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}

	@ApiOperation(value = "즐겨찾기 조회", response = List.class)
	@GetMapping("/list")
	public ResponseEntity<List<FavAddressDto>> listGet(
			@RequestBody @ApiParam(value = "회원 아이디", required = true) String userId) throws Exception {
		return new ResponseEntity<List<FavAddressDto>>(favoriteService.listFavorite(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "즐겨찾기 삭제", response = String.class)
	@GetMapping("/delete")
	public ResponseEntity<String> deleteGet(
			@RequestBody @ApiParam(value = "회원 아이디", required = true) FavoriteDto favoriteDto,
			HttpServletRequest request) throws Exception {
		if (favoriteService.deleteFavorite(favoriteDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
}