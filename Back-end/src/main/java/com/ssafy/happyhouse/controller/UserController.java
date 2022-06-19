package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dtos.UserDto;
import com.ssafy.happyhouse.services.JwtService;
import com.ssafy.happyhouse.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserController {
	private final String SUCCESS = "SUCCESS";
	private final String FAILURE = "FAILURE";
	private final String NO_SUCH_MEMBER = "NO SUCH MEMBER";

	@Autowired
	private JwtService jwtService;

	@Autowired
	private final UserService userService;

	@Autowired
	public UserController(JwtService jwtService, UserService userService) {
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@ApiOperation(value = "회원가입", response = String.class)
	@PostMapping("/register")
	public ResponseEntity<String> registerPost(@RequestBody UserDto userDto) throws Exception {
		if (userService.registerUser(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}

	@ApiOperation(value = "로그인", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginPost(
			@RequestBody @ApiParam(value = "회원아이디, 비밀번호", required = true) UserDto userDto) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.loginUser(userDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getId(), "access-token");// key, data, subject
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAILURE);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원정보 조회", response = Map.class)
	@GetMapping("/update")
	public ResponseEntity<Map<String, Object>> updateGet(
			@RequestBody @ApiParam(value = "회원 아이디", required = true) String userId, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			try {
				UserDto userDto = userService.userInfo(userId);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			resultMap.put("message", FAILURE);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원정보 수정", response = String.class)
	@PutMapping("/update")
	public ResponseEntity<String> updatePost(@RequestBody UserDto userDto) throws Exception {
		if (userService.updateUser(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.OK);
	}

	@ApiOperation(value = "회원 탈퇴", response = String.class)
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteGet(@RequestBody @ApiParam(value = "회원 아이디", required = true) String userid,
			HttpServletRequest request) throws Exception {
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			try {
				userService.deleteUser(userid);
				return new ResponseEntity<String>(SUCCESS, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<String>(FAILURE, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>(FAILURE, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "비밀번호 찾기", response = Map.class)
	@PostMapping("/findPassword")
	public ResponseEntity<Map<String, String>> findPasswordGet(
			@RequestBody @ApiParam(value = "회원 아이디, 전화번호", required = true) UserDto userDto, HttpServletRequest request)
			throws Exception {
		Map<String, String> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			try {
				if (userService.userInfo(userDto.getId()).getTelephone().equals(userDto.getTelephone())) {
					String password = userService.userInfo(userDto.getId()).getPassword();
					resultMap.put("password", password);
					resultMap.put("message", SUCCESS);
				} else {
					resultMap.put("message", NO_SUCH_MEMBER);
				}
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			resultMap.put("message", FAILURE);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, String>>(resultMap, status);
	}
}