package ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the todo database table.
 * 
 * Here we are mapping the Todo entity from a specific table in our MySql database
 */
@Entity
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idtodo;

	private int isDone;

	private String task;

	public Todo() {
	}

	public int getIdtodo() {
		return this.idtodo;
	}

	public void setIdtodo(int idtodo) {
		this.idtodo = idtodo;
	}

	public int getIsDone() {
		return this.isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "Todo [idtodo=" + idtodo + ", isDone=" + isDone + ", task="
				+ task + "]";
	}

}