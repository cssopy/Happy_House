package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dtos.NoticeDto;

@Mapper
public interface INoticeMapper {
	List<NoticeDto> searchNotices();
	NoticeDto readNotice(int idx);
	int insertNotice(NoticeDto noticeDto);
	int modifyNotice(NoticeDto noticeDto);
	int deleteNotice(int idx);
}
