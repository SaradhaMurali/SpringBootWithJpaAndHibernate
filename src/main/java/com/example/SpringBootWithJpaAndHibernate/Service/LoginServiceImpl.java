package com.example.SpringBootWithJpaAndHibernate.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.EhCache;
import org.springframework.stereotype.Service;

import com.example.SpringBootWithJpaAndHibernate.Entity.UserEntity;
import com.example.SpringBootWithJpaAndHibernate.Table.UserRepository;



@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired UserRepository userTable;
	
    @Override
  	public String register(UserEntity userDeatils) {
		List<UserEntity> UserEntityList= userTable.findByUserName(userDeatils.getUserName());
	    if(isAlreadyUser(UserEntityList,userDeatils)) {
	    	return "User Name was already used.Kindly give different User name";
	    }
	    userTable.save(userDeatils);
		return "User is Registered SuccessFully";
		
	}

	private boolean isAlreadyUser(List<UserEntity> UserEntityList, UserEntity userDeatils) {
		List<UserEntity> filteredList = UserEntityList.stream().
				filter(userInfo-> userInfo.getUserName().equals(userDeatils.getUserName()))
						.collect(Collectors.toList());
		return filteredList.isEmpty() ? false : true;
	}

	@Override
	public boolean login(String userName,String password) {
		//List<UserEntity> UserEntityList= userTable.findByUserName(userName);
		List<UserEntity> UserEntityList= userTable.findByUserName(userName);
		List<UserEntity> UserEntityList1= userTable.findByUserName(userName);
		System.out.println(UserEntityList.size());
		System.out.println(UserEntityList.get(0).getPassword());
		System.out.println(UserEntityList.get(0).getPhoneNumber());
		List<UserEntity> filteredList = UserEntityList.stream().
				filter(userInfo-> userInfo.getUserName().equals(userName) &&
						 userInfo.getPassword().equals(password)).collect(Collectors.toList());
		return filteredList.isEmpty() ? false : true;
	}
	
	
	

}
