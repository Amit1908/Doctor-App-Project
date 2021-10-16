package com.techment.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dao.IUserDao;
import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.User;
import com.techment.exception.AlreadyExist;
import com.techment.exception.NotFound;
import com.techment.service.IUserService;

import javassist.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/userController")
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired
	IUserDao dao;
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
		

		try {
			User Exist = dao.findByUsername(user.getUsername());			
			if(Exist!=null)
				throw new AlreadyExist("User is already exist");
			else {
				String output =  userService.register(user);
				return new ResponseEntity<String>(output,HttpStatus.CREATED);
			}			
		}catch(Exception e) {
			
			throw new AlreadyExist("User is already exist");
		}
		
		
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody UserDto user,@PathVariable int userId)
	{
		try {
			String Output = userService.updateUser(user, userId);
			return new ResponseEntity<String>(Output,HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			throw new NotFound("user not found");
		}
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId){
		
		try {
			return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFound("user not found");
		}
		
	}
	
	@GetMapping("/validateUser/{username}")
	public ResponseEntity<UserDtoShow> validate(@PathVariable String username){
		
		try {
			return new ResponseEntity<UserDtoShow>(userService.validateUser(username),HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFound("user not found");
		}
		
		
	}
	
	@GetMapping("/ViewAll")
	public List<User> ViewAllUsers(){
		return userService.ViewAllUsers();		
		
	}
	
	@PostMapping("/LoginProcess")
	public ResponseEntity<UserDto> UserLoginProcess(@RequestBody UserDto dto){
		
		try {
			return new ResponseEntity<UserDto>(userService.UserLogIn(dto.getUsername(), dto.getPassword()),HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFound("user not found");
		}
		
		
	}
}
