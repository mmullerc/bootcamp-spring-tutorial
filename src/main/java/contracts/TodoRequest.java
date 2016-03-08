package contracts;


/**
 * Todo Request
 *
 *Its the Request that the API recieves when dealing with Todos
 */
public class TodoRequest extends BasePagingRequest {

	public int id;
	public String task;
	public int isDone;
	
	public TodoRequest(){
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
		return "TodoRequest [id=" + id + ", task=" + task + ", isDone="
				+ isDone + "]";
	}
}
