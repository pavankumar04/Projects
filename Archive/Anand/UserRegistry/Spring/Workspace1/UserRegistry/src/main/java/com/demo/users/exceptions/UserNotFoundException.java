package com.demo.users.exceptions;


public class UserNotFoundException extends Exception  {
	private static final long serialVersionUID = 1234567890L;
	
	public UserNotFoundException(String message) {
        super(message);
    }

}
