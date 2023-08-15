package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginDAO;


@Controller

public final class LoginController {
	
	@Autowired
	LoginDAO loginDao;
	
	@PostMapping("/Login")
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		

		if(loginDao.checkUser(uname,pass)) {
			HttpSession session =request.getSession();
			session.setAttribute("username", uname);
			mv.setViewName("Search");
		}
		else {
			mv.setViewName("Login");
		}
	return mv;
	}
}
