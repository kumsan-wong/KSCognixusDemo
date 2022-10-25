package com.example.demo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todo.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
	
}
