package logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
/**
 * Simple Logger Aspect
 * Logs a String before and after our controller methods
 * 
 * @author Mathias
 * 
 */
public class Logger {
	
	//Todo Creation

	@Before("execution(* controllers.TodoController.createTodo(*))")
	public void beforeCreatingTodo(){
		System.out.println("Creating a new Todo");
	}
	
	@AfterReturning("execution(* controllers.TodoController.createTodo(*))")
	public void afterCreatingTodo(){
		System.out.println("Todo creation method finished");
	}
	
	@AfterThrowing("execution(* controllers.TodoController.createTodo(*))")
	public void creationThrow(){
		System.out.println("Todo Creation error");
	}
	
	//Todo Update
	
	@Before("execution(* controllers.TodoController.updateTodo(*))")
	public void beforeUpdatingTodo(){
		System.out.println("Updating a Todo");
	}
	
	@AfterReturning("execution(* controllers.TodoController.updateTodo(*))")
	public void afterUpdatingTodo(){
		System.out.println("Todo update method finished");
	}
	
	@AfterThrowing("execution(* controllers.TodoController.updateTodo(*))")
	public void updateThrow(){
		System.out.println("Update Todo Error");
	}
	
	//Todo List
	
	@Before("execution(* controllers.TodoController.getAll())")
	public void beforeGetAllTodos(){
		System.out.println("Getting all Todos");
	}
	
	@AfterReturning("execution(* controllers.TodoController.getAll())")
	public void afterGettingAllTodos(){
		System.out.println("Todo get All method finished");
	}
	
	@AfterThrowing("execution(* controllers.TodoController.getAll())")
	public void getThrow(){
		System.out.println("Get Todo's Error");
	}
	
	//Todo Delete
	
	@Before("execution(* controllers.TodoController.deleteTodo(*))")
	public void beforeDeletingTodo(){
		System.out.println("Deleting a Todo");
	}
	
	@AfterReturning("execution(* controllers.TodoController.deleteTodo(*))")
	public void afterDeletingTodo(){
		System.out.println("Todo delete method finished");
	}
	
	@AfterThrowing("execution(* controllers.TodoController.deleteTodo(*))")
	public void todoDeleteThrow(){
		System.out.println("Delete Todo's Error");
	}
}
