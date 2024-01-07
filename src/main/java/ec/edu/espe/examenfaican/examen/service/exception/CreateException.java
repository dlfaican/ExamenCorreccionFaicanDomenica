package ec.edu.espe.examenfaican.examen.service.exception;

public class CreateException extends RuntimeException{
    public CreateException(String message){
        super(message);
    }
    public CreateException(String message, Exception cause){
        super(message, cause);
    }
}