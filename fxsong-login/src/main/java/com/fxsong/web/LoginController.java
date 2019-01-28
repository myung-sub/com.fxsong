package com.fxsong.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fxsong.dao.UserDAO;
import com.fxsong.model.UserVO;
import com.fxsong.service.UserService;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping("/getLoginForm")
	public ModelAndView getLoginForm(@RequestParam(value="error", required = false) String error) {
		log.debug("fxsong 111111");

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "hello fxsong");

		if (error != null) {
			model.addObject("error", "the user name or password is incorrect!");
		}
		
		model.setViewName("loginForm");
		return model;
	}
	
	@RequestMapping("/procLogin")
	public String procLogin(HttpServletRequest request, HttpSession session, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserVO userVO = userService.getUser(username);
		log.debug(userVO.toString());

		session.setAttribute("userVo", userVO);
		return "home";
	}
	
	@RequestMapping("/home2")
	public String home() {
		log.debug("fxsong 111111");
		return "home";
	}
}
