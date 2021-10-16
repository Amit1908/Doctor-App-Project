package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IUserDao;
import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.User;
import com.techment.service.IUserService;
import com.techment.util.SiteUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userdao;

	@Autowired
	SiteUtil siteutil;

	@Override
	public String register(UserDto user) {
	

		User user1 = new User(user.getUsername(), user.getPassword(), user.getRole());
		userdao.save(user1);
		return "User sucessfully Added";

	}



	@Override
	public String deleteUser(int userId) {
		userdao.deleteById(userId);

		return "User deleted";
	}

	@Override
	public String updateUser(UserDto user,int userId) {

		User oldUser = userdao.findById(userId).get();

		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());

		userdao.save(oldUser);




		return "Updated";
	}

	@Override
	public UserDtoShow validateUser(String user) {       
		User tokenUpdateuser =  userdao.findByUsername(user);
		if(tokenUpdateuser!= null)
		{
			String token = siteutil.generateToken();  	
			tokenUpdateuser.setToken(token);  	
			userdao.save(tokenUpdateuser);
		}



		UserDtoShow dto = new UserDtoShow(tokenUpdateuser.getUsername(), tokenUpdateuser.getToken());
		return dto;
	}



	@Override
	public List<User> ViewAllUsers() {
		List<User> userlist = userdao.findAll();
		return userlist;
	}



	@Override
	public UserDto UserLogIn(String user, String Password) {
		User tokenUpdateuser =  userdao.findByUsernameAndPassword(user, Password);
		if(tokenUpdateuser!= null)
		{
			String token = siteutil.generateToken();  	
			tokenUpdateuser.setToken(token);  	
			userdao.save(tokenUpdateuser);
		}


		//UserDto userDto = new UserDto(tokenUpdateuser.getUserId(),tokenUpdateuser.getUsername(), tokenUpdateuser.getPassword(), tokenUpdateuser.getRole(), tokenUpdateuser.getToken());
		UserDto dto = new UserDto(tokenUpdateuser.getUsername(), tokenUpdateuser.getToken());
		
		return dto;
	}




}
