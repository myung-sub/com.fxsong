package com.fxsong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fxsong.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:spring/context-datasource.xml",
		"classpath:spring/context-mybatis.xml"
})
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	public void testGetUser() {
		String userId = "grcadmin";
		UserVO userVO = userService.getUser(userId);
		System.out.println(userVO);
	}

}
