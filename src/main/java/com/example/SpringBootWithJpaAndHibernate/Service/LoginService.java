package com.example.SpringBootWithJpaAndHibernate.Service;

import com.example.SpringBootWithJpaAndHibernate.Entity.UserEntity;

public interface LoginService {
	
	public String register(UserEntity userDetail);
	
	public boolean login(String userName,String password);
	
	
	
	

}
