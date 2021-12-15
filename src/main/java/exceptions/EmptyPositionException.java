package exceptions;

public class EmptyPositionException extends RuntimeException{

    public EmptyPositionException(String message) {
        super(message);
    }
}
