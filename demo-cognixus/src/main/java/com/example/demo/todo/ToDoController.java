package com.example.demo.todo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.todo.service.ToDoService;

@RestController
@RequestMapping(path = "/api/todo")
public class ToDoController {
	@Autowired
	private ToDoService serv;
	
	@GetMapping("/all")
	public List<ToDo> listAll() {
		return serv.listToDo();
	}
	
	@PostMapping("/add")
	public ToDo addEntry(@RequestBody ToDo todo) {
		return serv.saveTodo(todo);
	}
	
	@PutMapping("/upd")
	public ToDo updateEntry(@RequestBody ToDo todo) {
		return serv.updTodo(todo);
	}
	
	@PutMapping("/mark/complete/{id}")
	public ToDo updateEntry(@PathVariable Long id) {
		//todo.setId(id);
		return serv.updTodoComplete(id);
	}
	
	@DeleteMapping("/del/{id}")
	void deleteEmployee(@PathVariable Long id) {
		serv.delTodo(id);
	}
}
