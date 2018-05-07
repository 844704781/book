package com.watermelon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watermelon.mapper.UserMapper;
import com.watermelon.pojo.User;
@Service
public class UserService {
   
	@Autowired
	private UserMapper userMapper;
	
	public int insert(User user){ 
		return userMapper.insert(user);
	}
}
