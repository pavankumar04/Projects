package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;

@Service
public class UserService {
	
	private List<User> userList;
	
	public UserService() {
		userList = new ArrayList<>();
		
		User user1 = new User(1,"lokesh",27,"lokesh2@gamil.com");
		User user2 = new User(2,"rajesh",32,"rajesh3@gamil.com");
		User user3 = new User(3,"rani",26,"rani3@gamil.com");
		User user4 = new User(4,"kiran",28,"kiran14@gamil.com");
		User user5 = new User(5,"hari",31,"hari5@gamil.com");
		
		userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
	}
	
	public List<User> showUsers()
	{
		return userList;
	}
	
	
	public User getUser(int id)throws UserNotFoundException
	{
		for(User user : userList) 
		{
			if(id == user.getId()) 
			{
				System.out.println(user.toString());
				return user;
			}
		}
		throw new UserNotFoundException("User with id " + id + " not found");
	}


	public void updateUser(int id, User user) 
	{
		for(int i = 0 ; i < userList.size(); i ++)
		{
			if(userList.get(i).getName().equals(user.getName()))
			{
				//updating age
				if(user.getAge()!=0)
				{
					userList.get(i).setAge(user.getAge());
				}
				
				if(user.getEmail()!=null)
				{
					userList.get(i).setEmail(user.getEmail());				}
				}
					
			}
	}

	public String saveUser(User us) 
	{	
		userList.add(us);
		return "user added";
	}

	public User updateUserById(int id,User user) 
	{
		for(int i = 0 ; i < userList.size(); i++)
		{
			if(userList.get(i).getId() == id)
			{
				System.out.println(userList.get(i).getName());
				if(user.getAge()!=0)
				{
					userList.get(i).setAge(user.getAge());
				}
				
				if(user.getEmail()!=null)
				{
					userList.get(i).setEmail(user.getEmail());				
				}
				if(user.getName()!=null)
				{
					userList.get(i).setName(user.getName());
				}
				return userList.get(i);
			}
		}	
		return null;
	}
	
	public User updateUserByName(String username , User user)
	{
		for(int i = 0 ; i < userList.size(); i++)
		{
			if(userList.get(i).getName().equals(username))
			{
				System.out.println(userList.get(i).getName());
				if(user.getAge()!=0)
				{
					userList.get(i).setAge(user.getAge());
				}
				if(user.getEmail()!=null)
				{
					userList.get(i).setEmail(user.getEmail());				
				}
				return userList.get(i);
			}
		}	
		return null;
	}
}
