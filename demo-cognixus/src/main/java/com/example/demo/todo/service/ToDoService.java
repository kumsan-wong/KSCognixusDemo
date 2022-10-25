package com.example.demo.todo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.todo.ToDo;
import com.example.demo.todo.exception.MissingReqParamException;
import com.example.demo.todo.exception.ToDoNotFoundException;
import com.example.demo.todo.repository.ToDoRepository;
import com.example.demo.todo.repository.ToDoStatus;

@Service
public class ToDoService {
	@Autowired
	private final ToDoRepository repo;
	
	Logger logger = LoggerFactory.getLogger(ToDoService.class);
	
	public ToDoService (ToDoRepository repo) {
		this.repo=repo;
	}
	
	public List<ToDo> listToDo() {
		return repo.findAll();
	}
	
	public ToDo getTodo(Long id) {
		ToDo exTodo=null;
		exTodo=repo.findById(id).orElseThrow(()->new ToDoNotFoundException(id));
		
		return exTodo;
	}
	
	public ToDo saveTodo(ToDo todo) {
		if (todo.getName()==null || todo.getName().isEmpty())
			throw new MissingReqParamException("name");
		if (todo.getStatus()==null)
			throw new MissingReqParamException("status");
		
		todo.setId(null);
		todo.setInsertDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		todo.setUpdateDate(null);
		return repo.save(todo);
	}
	
	public ToDo updTodo(ToDo todo) {
		ToDo exTodo=getTodo(todo.getId());
		
		exTodo.setName(todo.getName());
		exTodo.setDescription(todo.getDescription());
		exTodo.setPerformDate(todo.getPerformDate());
		exTodo.setUpdateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		
		return repo.save(exTodo);
	}
	
	public ToDo updTodoComplete(Long id) {
		ToDo exTodo=getTodo(id);
		
		exTodo.setStatus(ToDoStatus.COMPLETE);
		exTodo.setUpdateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		
		return repo.save(exTodo);
	}
	
	public boolean delTodo(Long id) {
		ToDo exTodo=getTodo(id);
		repo.delete(exTodo);
		return true;
	}
	
	public boolean delTodo(ToDo todo) {
		repo.deleteById(todo.getId());
		return true;
	}
}
