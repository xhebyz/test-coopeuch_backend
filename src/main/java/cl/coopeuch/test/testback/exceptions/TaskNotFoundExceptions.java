package cl.coopeuch.test.testback.exceptions;

public class TaskNotFoundExceptions extends RuntimeException{
    public TaskNotFoundExceptions(Long id) {
        super("Not found task id= " + id);
    }
}
