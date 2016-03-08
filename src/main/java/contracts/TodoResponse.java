package contracts;

import java.util.List;

import pojos.TodoPOJO;

/**
 * Todo Response
 * 
 * Its the Todo response that API returns
 * 
 * @author Mathias
 *
 */
public class TodoResponse extends BaseResponse {
	
	private List<TodoPOJO> todos; 

	public TodoResponse() {
		super();
	}
	
	public List<TodoPOJO> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoPOJO> todos) {
		this.todos = todos;
	}
}
