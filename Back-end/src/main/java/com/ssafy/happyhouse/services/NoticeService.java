package com.ssafy.happyhouse.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dtos.NoticeDto;
import com.ssafy.happyhouse.model.mapper.INoticeMapper;

@Service
public class NoticeService {
	
	@Autowired
	INoticeMapper noticeMapper;
	
	public List<NoticeDto> searchNotices() {
		return noticeMapper.searchNotices();
	}
	
	public NoticeDto readNotice(int idx) {
		return noticeMapper.readNotice(idx);
	}

	public boolean insertNotice(NoticeDto noticeDto) {
		Date today = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy/MM/dd");
		String date = date1.format(today);
		noticeDto.setDate(date);
		return noticeMapper.insertNotice(noticeDto) == 1;
	}

	public boolean modifyNotice(NoticeDto noticeDto) {
		return noticeMapper.modifyNotice(noticeDto) == 1;		
	}

	public boolean deleteNotice(int idx) {
		return noticeMapper.deleteNotice(idx) == 1;
	}	
}
