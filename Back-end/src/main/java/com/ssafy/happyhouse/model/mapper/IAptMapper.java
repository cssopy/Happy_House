package com.ssafy.happyhouse.model.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dtos.AptDto;

@Mapper
public interface IAptMapper {
	ArrayList<AptDto> selectAptById(String aptId);	
	ArrayList<AptDto> selectAptByDong(String dong);
}
