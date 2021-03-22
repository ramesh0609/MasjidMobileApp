package com.allmuslim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserExist extends RuntimeException{
	
	public UserExist(String exception)
	{
		super(exception);
	}

}
