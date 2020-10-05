package com.example.SpringBootWithJpaAndHibernate.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootWithJpaAndHibernate.Entity.UserEntity;
import com.example.SpringBootWithJpaAndHibernate.Service.LoginService;
	


@RestController
public class LoginController {
	
	@Autowired LoginService loginService;
	
	@PostMapping(path = "/register")
	public String register(UserEntity userDetails){
		return loginService.register(userDetails);
	}
	
	@GetMapping(path = "/login")
	public String login(String userName,String password){
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			return "UserName or Password should not be empty";
		}
		boolean isValid=loginService.login(userName,password);
		if(isValid) {
			return "Login SucessFully";
		}
		return "UserName or Password is incorrect.";
	}

}
