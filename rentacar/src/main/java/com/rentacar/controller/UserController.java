package com.rentacar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.dto.UserDTO;
import com.rentacar.dto.request.UserRequest;
import com.rentacar.dto.response.ResponseMessage;
import com.rentacar.dto.response.VRResponse;
import com.rentacar.mapper.UserMapper;
import com.rentacar.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	private UserMapper userMapper;

	@Autowired
	public UserController(UserService userService, UserMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@GetMapping("/auth/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userDTOs = userService.getAllUsers();
		return ResponseEntity.ok(userDTOs);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<UserDTO> getCurrentlyUser() {
		UserDTO userDTO = userService.getCurrentlyUser();
		return ResponseEntity.ok(userDTO);
	}

	@GetMapping("/page")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Page<UserDTO>> getAllUserByPage(@RequestParam("page") int page,
			@RequestParam("size") int size, @RequestParam("sort") String prop,
			@RequestParam(value = "direction", required = false, defaultValue = "DESC") Direction direction) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
		Page<UserDTO> pageUserDTO = userService.getUserPage(pageable);
		return ResponseEntity.ok(pageUserDTO);
	}
	
	@GetMapping("/{id}/auth")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id")Long id){
		UserDTO userDTO=userService.getUserById(id);
		return ResponseEntity.ok(userDTO);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> updateUser(@PathVariable("id")Long id,
												@Valid @RequestBody UserRequest userRequest){
		userService.updateUser(id,userRequest);
		VRResponse response=new VRResponse(ResponseMessage.USER_UPDATE_RESPONSE,true);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
}
