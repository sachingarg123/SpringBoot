package com.rest.webservices.restwebservices.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
