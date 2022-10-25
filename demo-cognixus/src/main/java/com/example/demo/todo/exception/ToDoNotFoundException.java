package com.example.demo.todo.exception;

public class ToDoNotFoundException extends RuntimeException {
	public ToDoNotFoundException() {
		
	}
	
	public ToDoNotFoundException(Long id) {
		super("Could not find entry " + id);
	}
}
