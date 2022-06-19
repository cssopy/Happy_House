package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dtos.AptDto;
import com.ssafy.happyhouse.services.AptService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping(value = "/aptSearch")
public class AptController {
	@Autowired
	private final AptService aptService;
	
	@Autowired
	public AptController(AptService aptService) {
		this.aptService = aptService;
	}

	@ApiOperation(value = "동으로 아파트 검색", response = List.class)
	@GetMapping("/searchByDong")
	public ResponseEntity<List<AptDto>> boardGet(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<AptDto>>(aptService.selectAptByDong(dong), HttpStatus.OK);
	}
}