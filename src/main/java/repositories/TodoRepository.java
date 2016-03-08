package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejb.Todo;

/**
 * Todo Repository
 *
 * This repository communicates with the MySql database
 *
 * @author Mathias
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {

}
