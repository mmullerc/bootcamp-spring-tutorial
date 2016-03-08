package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pojos.TodoPOJO;
import contracts.TodoRequest;
import contracts.TodoResponse;
import ejb.Todo;
import services.TodoServiceInterface;

/**
 * This Rest Controller maps all the Todo end points with specific functions
 * to provide functionality to the /todos RESTful API
 * 
 * @author Mathias
 *
 */
@RestController //Indicates Spring that this is a Web Controller, adds the @Controller and @ResponseBody annotations
public class TodoController {

	@Autowired //Injects the TodoServiceInterface as dependency to this Controller
	TodoServiceInterface todoService;

	/**
	 * Gets all Todo's
	 * @return TodoResponse
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "*") //Can receive a request from any origin
	@RequestMapping(value = "/getTodos", method = RequestMethod.GET) //Maps the /getTodos route with the getAll() function
	public TodoResponse getAll(){

		TodoResponse todoResp = new TodoResponse();

		List<Todo> todoList = todoService.getAll();
		List<TodoPOJO> todos = new ArrayList<TodoPOJO>();

		todoList.forEach(t -> {

			TodoPOJO todo = new TodoPOJO();
			todo.setId(t.getIdtodo());
			todo.setTask(t.getTask());
			todo.setIsDone(t.getIsDone());
			todos.add(todo);
		});
		
		todoResp.setTodos(todos);

		todoResp.setCode(200);
		todoResp.setCodeMessage("todos fetch success");
		return todoResp;
	}

	/**
	 * Creates a new Todo
	 * @param todoRequest
	 * @return TodoResponse
	 */
	@CrossOrigin(origins = "*") //Can receive a request from any origin
	@RequestMapping(value = "/createTodo", method = RequestMethod.POST) //Maps the /createTodo route with the createTodo() function
	public TodoResponse createTodo(@RequestBody TodoRequest todoRequest) {

		Todo todo = new Todo();
		todo.setTask(todoRequest.getTask());
		todo.setIsDone(0);
		todo = todoService.createTodo(todo);

		TodoResponse todoResp = new TodoResponse();

		if (todo != null) {
			todoResp.setCode(200);
			todoResp.setCodeMessage("Todo created succesfully");

			List<TodoPOJO> todos = new ArrayList<TodoPOJO>();
			TodoPOJO todoPojo = new TodoPOJO();
			todoPojo.setId(todo.getIdtodo());
			todoPojo.setTask(todo.getTask());
			todoPojo.setIsDone(todo.getIsDone());
			todos.add(todoPojo);

		} else {
			todoResp.setCode(500);
			todoResp.setCodeMessage("Internal Server Error");
		}

		return todoResp;
	}

	/**
	 * Updates a new Todo
	 * @param todoRequest
	 * @return TodoResponse
	 */
	@CrossOrigin(origins = "*") //Can receive a request from any origin
	@RequestMapping(value = "/updateTodo", method = RequestMethod.PUT) //Maps the /updateTodo route with the updateTodo() function
	public TodoResponse updateTodo(@RequestBody TodoRequest todoRequest) {

		Todo todo = new Todo();
		todo.setIdtodo(todoRequest.getId());
		todo.setTask(todoRequest.getTask());
		todo.setIsDone(todoRequest.getIsDone());
		todo = todoService.updateTodo(todo);

		TodoResponse todoResp = new TodoResponse();

		if (todo != null) {
			todoResp.setCode(200);
			todoResp.setCodeMessage("Todo updated succesfully");

			List<TodoPOJO> todos = new ArrayList<TodoPOJO>();
			TodoPOJO todoPojo = new TodoPOJO();
			todoPojo.setId(todo.getIdtodo());
			todoPojo.setTask(todo.getTask());
			todoPojo.setIsDone(todo.getIsDone());
			todos.add(todoPojo);

			todoResp.setTodos(todos);
		} else {
			todoResp.setCode(500);
			todoResp.setCodeMessage("Internal Server Error");
		}

		return todoResp;
	}

	/**
	 * Deletes a Todo
	 * @param todoId
	 * @return TodoResponse
	 */
	@CrossOrigin(origins = "*") //Can receive a request from any origin
	@RequestMapping(value = "/deleteTodo", method = RequestMethod.DELETE)//Maps the /deleteTodo route with the deleteTodo() function
	public TodoResponse deleteTodo(@RequestParam("id") int todoId) {

		Boolean deleted = todoService.deleteTodo(todoId);

		TodoResponse todoResp = new TodoResponse();

		if (deleted == true) {
			todoResp.setCode(200);
			todoResp.setCodeMessage("Todo deleted succesfully");
		}

		return todoResp;
	}

}
