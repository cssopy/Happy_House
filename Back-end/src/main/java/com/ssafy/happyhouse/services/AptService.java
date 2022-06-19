package com.ssafy.happyhouse.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dtos.AptDto;
import com.ssafy.happyhouse.model.mapper.IAptMapper;

@Service
public class AptService {
	@Autowired
	IAptMapper aptMapper;

	public ArrayList<AptDto> selectAptByDong(String dong) {
		return aptMapper.selectAptByDong(dong);
	}

	public ArrayList<AptDto> selectAptById(String dong) {
		return aptMapper.selectAptByDong(dong);
	}
}
