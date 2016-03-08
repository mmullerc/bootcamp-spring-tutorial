package repositories;

import org.springframework.data.repository.CrudRepository;
import ejb.Todo;

/**
 * Todo Repository
 *
 *This repository communicates with the MySql database
 */
public interface TodoRepository extends CrudRepository<Todo,Integer> {

}
