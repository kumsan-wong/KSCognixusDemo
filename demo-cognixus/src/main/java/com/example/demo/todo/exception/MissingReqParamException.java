package com.example.demo.todo.exception;

public class MissingReqParamException extends RuntimeException {
	public MissingReqParamException() {
		
	}
	
	public MissingReqParamException(String param) {
		super("Missing parameter: " + param);
	}
}
