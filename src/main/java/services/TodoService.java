package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TodoRepository;
import ejb.Todo;


/**
 * Todo Service, implements the TodoServiceInterface
 *
 *It's main function is to provide communication between the RestControllers and the repositories.
 *
 * @author Mathias
 */
@Service
public class TodoService implements TodoServiceInterface{

	@Autowired TodoRepository todoRep;
	
	/**
	 * Indicates the TodoRepository to find a Todo by a given id
	 * @return Todo
	 */
	@Override
	public Todo getTodo(int id) {
		
		Todo todo =	todoRep.findOne(id);
		
		return todo;
	}

	/**
	 * Indicates the TodoRepository to get All TODOS that are in the database
	 * @return List<Todo>
	 */
	@Override
	public List<Todo> getAll() {
		
		List<Todo> todos;
		
		todos = (List<Todo>) todoRep.findAll();
		
		return todos;
	}

	/**
	 * Indicates the TodoRepository to create a new Todo 
	 * @param Todo 
	 * @return Todo
	 */
	@Override
	public Todo createTodo(Todo todo) {
		
		Todo newTodo;
		
		newTodo = todoRep.save(todo);
		
		return newTodo;
	}

	/**
	 * Indicates the TodoRepository to update a given TODO
	 * @param Todo 
	 * @return Todo
	 */
	@Override
	public Todo updateTodo(Todo todo) {
		
		Todo updatedTodo;
		
		updatedTodo = todoRep.save(todo);
		
		return updatedTodo;
	}

	/**
	 * Indicates the TodoRepository to delete a Todo by a given id
	 * @return Boolean
	 */
	@Override
	public Boolean deleteTodo(int id) {
		
		Boolean deleted;
		
		try{
			
			todoRep.delete(id);
			deleted = true;
			
		}catch(Exception e){
		
			System.out.println(e);
			deleted = false;
			
		}
	
		return deleted;
	}

}
