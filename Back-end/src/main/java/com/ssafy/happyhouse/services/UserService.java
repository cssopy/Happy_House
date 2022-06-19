package com.ssafy.happyhouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dtos.UserDto;
import com.ssafy.happyhouse.model.mapper.IUserMapper;

@Service
public class UserService {
	private final IUserMapper userMapper;
	
	@Autowired
	public UserService(IUserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public boolean registerUser(UserDto userDto) throws Exception {
		if(userDto.getId().equals("") || userDto.getPassword().equals("")) return false;
		if(userMapper.selectUserById(userDto.getId()) != null) return false;
		String regExp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
		String phone = userDto.getTelephone();
		if (phone.length() > 13 || !phone.matches(regExp)) return false;
		
		return userMapper.insertUser(userDto) == 1;
	}
	
	public UserDto loginUser(UserDto userDto) throws Exception {
		String id = userDto.getId();
		String password = userDto.getPassword();
		if(id.equals("") || password.equals("")) return null;
		return userMapper.selectUserByIdPassword(id, password);
	}
	
	public boolean deleteUser(String userId) {
		return userMapper.deleteUser(userId) == 1;
	}
	
	public boolean updateUser(UserDto userDto) {
		if(userDto.getPassword().equals("")) return false;
		String regExp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
		String phone = userDto.getTelephone();
		if (phone.length() > 13 || !phone.matches(regExp)) return false;
	
		return userMapper.updateUser(userDto) == 1;
	}
	
	public UserDto userInfo(String userId) {
		return userMapper.selectUserById(userId);
	}
	
	public UserDto findPassword(String id, String name, String telephone) {
		UserDto userDto = null;
		
		userDto = userMapper.selectUserById(id);
		
		return userDto;
	}
}