package com.fxsong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxsong.dao.UserDAO;
import com.fxsong.model.UserVO;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	public UserVO getUser(String userId){
		UserVO userVO = userDAO.selectOne(userId);
		return userVO;
	}

}
