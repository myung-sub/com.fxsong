package com.fxsong.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fxsong.model.UserVO;
import com.fxsong.util.CamelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:spring/context-datasource.xml",
		"classpath:spring/context-mybatis.xml"
})
public class UserDAOTest {
	
	@Resource
	UserDAO userDAO;

	@Test
	public void selectOne() {
		String userId = "grcadmin";
		UserVO dbvo = userDAO.selectOne(userId);
		assertThat(dbvo.getUserId(), is(userId));
		System.out.println(dbvo);
	}

	@Test
	@Ignore
	public void selectList() {
		UserVO vo = new UserVO();
		vo.setUserId("grcadmin");
		List<CamelMap> list = userDAO.selectList(vo);
		for (CamelMap camelMap : list) {
			System.out.println(camelMap.toString());
		}
	}

}
