package com.ssafy.happyhouse.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dtos.UserDto;

@Mapper
public interface IUserMapper {
	int deleteUser(String userId);
	
	int insertUser(UserDto userDto);
	
	UserDto selectUserById(String id);
	
	UserDto selectUserByIdPassword(
			@Param("id") String id,
			@Param("pass") String pass);
	
	int updateUser(UserDto userDto);
}
