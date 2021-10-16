package com.techment.service;

import java.util.List;


import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.User;

public interface IUserService {

	//UserDto register(UserDto user);
	String register(UserDto user);
	String deleteUser(int userId);
	String updateUser(UserDto user,int userId);
	UserDtoShow validateUser(String user);
	List<User> ViewAllUsers();
	UserDto UserLogIn(String user,String Password);
	//Patientdto PatientLogin(String username,String password); // View respect to mobile and password
}
