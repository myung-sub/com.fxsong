package com.fxsong.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fxsong.model.UserVO;
import com.fxsong.util.CamelMap;

@Repository
public interface UserDAO {
	
	public UserVO selectOne(String userId);
	
	public List<CamelMap> selectList(UserVO userVO);
}
