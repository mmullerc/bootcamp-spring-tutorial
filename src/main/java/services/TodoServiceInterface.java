package services;

import java.util.List;

import org.springframework.stereotype.Service;
import ejb.Todo;

/**
 * Todo Service Interface
 * 
 * Provides the CRUD services to the Todo RestController
 * 
 * @author Mathias
 */
@Service
public interface TodoServiceInterface {
	
	Todo getTodo(int id);
	List<Todo> getAll();
	Todo createTodo(Todo todo);
	Todo updateTodo(Todo todo);
	Boolean deleteTodo(int id);
	
}
