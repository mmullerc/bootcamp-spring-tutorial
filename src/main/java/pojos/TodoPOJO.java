package pojos;


/**
 * Todo POJO (Plain Old Java Object).
 */
public class TodoPOJO {

	public int id;
	public String task;
	public int isDone;

	public TodoPOJO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getIsDone() {
		return isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String toString() {
		return "TodoPOJO [id=" + id + ", task=" + task + ", isDone=" + isDone
				+ "]";
	}
}
