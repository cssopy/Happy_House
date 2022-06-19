package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dtos.NoticeDto;
import com.ssafy.happyhouse.services.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/Notice")
public class NoticeController {
	private final String SUCCESS = "SUCCESS";
	private final String FAILURE = "FAILURE";
	
	@Autowired
	private final NoticeService noticeService;
	
	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@ApiOperation(value = "공지사항 조회", response = List.class)
	@GetMapping("/searchNotices")
	public ResponseEntity<List<NoticeDto>> searchNotices() throws Exception {
		return new ResponseEntity<List<NoticeDto>>(noticeService.searchNotices(), HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 상세조회", response = NoticeDto.class)
	@GetMapping("/readNotice")
	public ResponseEntity<NoticeDto> readNotice(@RequestParam("idx") int idx) throws Exception {
		return new ResponseEntity<NoticeDto>(noticeService.readNotice(idx), HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항 입력", response = String.class)
	@PostMapping("/insertNotice")
	public String insertNotice(NoticeDto noticeDto) {
		noticeService.insertNotice(noticeDto);
		return "redirect:/Notice/searchNotices";
	}
	public ResponseEntity<NoticeDto> insertNotice(@RequestParam("idx") int idx) throws Exception {
		return new ResponseEntity<NoticeDto>(noticeService.readNotice(idx), HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 수정 화면", response = NoticeDto.class)
	@GetMapping("/modifyNotice")
	public ResponseEntity<NoticeDto> modifyNoticeView(@RequestParam("idx") int idx) throws Exception {
		return new ResponseEntity<NoticeDto>(noticeService.readNotice(idx), HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 수정", response = String.class)
	@PutMapping("/modifyNotice")
	public ResponseEntity<String> modifyNotice(NoticeDto noticeDto, @RequestParam("idx") int idx) {
		if (noticeService.insertNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 삭제", response = String.class)
	@DeleteMapping("/deleteNotice")
	public ResponseEntity<String> deleteNotice(@RequestParam("idx") int idx) {
		if (noticeService.deleteNotice(idx)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}
}
