package com.example.demo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ToDoNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(ToDoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String todoNotFoundHandler(ToDoNotFoundException todo) {
		return todo.getMessage();
	}
}
