package com.visionrent.service;


import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.visionrent.domain.Role;
import com.visionrent.domain.User;
import com.visionrent.domain.enums.RoleType;
import com.visionrent.dto.request.RegisterRequest;
import com.visionrent.exception.ConflictException;
import com.visionrent.exception.ResourceNotFoundException;
import com.visionrent.exception.message.ErrorMessage;
import com.visionrent.repository.UserRepository;
@Service
public class UserService {
	

	private UserRepository userRepository;
	

	private RoleService roleService ;
	

	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	public UserService(UserRepository userRepository, RoleService roleService, @Lazy PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
	}
	public User getUserByEmail(String email ) {
		
		  User user  =  userRepository.findByEmail(email).orElseThrow(()->
		  			new ResourceNotFoundException(String.format(ErrorMessage.USER_NOT_FOUND_MESSAGE, email))
				);
		return user ;
	}
	public void saveUser(RegisterRequest registerRequest) {
		if(userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE,
																											registerRequest.getEmail()));
		}
		
		Role role = roleService.findByType(RoleType.ROLE_CUSTOMER);
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		String encodedPassword =  passwordEncoder.encode(registerRequest.getPassword());
		
		User user = new User();
		
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(encodedPassword);
		user.setPhoneNumber(registerRequest.getPhoneNumber());
		user.setAddress(registerRequest.getAddress());
		user.setZipCode(registerRequest.getZipCode());
		user.setRoles(roles);
		
		userRepository.save(user);
		
		
		
	}
	
}