package com.fxsong.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fxsong.dao.UserDAO;
import com.fxsong.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:spring/context-datasource.xml",
		"classpath:spring/context-servlet.xml"
})
@WebAppConfiguration
public class LoginControllerTest {

	@Autowired
	WebApplicationContext wac;
	
	@Mock
	UserDAO userDAO;
	
	@InjectMocks
	private LoginController loginController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
//		mockMvc = webAppContextSetup(wac)
//		mockMvc = standaloneSetup(new LoginController())
		mockMvc = standaloneSetup(loginController)
				.alwaysExpect(status().isOk())
				.build();
	}

	@Test
	@Ignore
	public void loginForm() throws Exception{
		mockMvc
		.perform(get("/getLoginForm"))
		.andExpect(model().attribute("msg", "hello fxsong"))
		.andExpect(view().name("loginForm"))
//		.andExpect(model().attribute("username", "admin"))
		.andDo(MockMvcResultHandlers.print())
		;
	}
	
	@Test
//	@Ignore
	public void loginProc() throws Exception{
		MvcResult mvcResult = mockMvc
				.perform(post("/procLogin")
						.param("username", "grcadmin")
						.param("password", "1234")
				 )
				.andExpect(view().name("home"))
				.andReturn();
		HttpSession session = mvcResult.getRequest().getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVo");
		assertThat(userVO, notNullValue());
		assertThat(userVO.getUserId(), equalTo("grcadmin"));
	}
	
	@Test
	@Ignore
	public void home() throws Exception{
		mockMvc
		.perform(get("/home2"))
		.andExpect(view().name("home"))
		.andDo(MockMvcResultHandlers.print())
		;
	}
	
}
