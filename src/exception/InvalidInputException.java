package exception;

/**
 * @author javid
 * Created on 2/6/2022
 */
public class InvalidInputException extends RuntimeException{

    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
