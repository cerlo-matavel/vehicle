package exceptions;

public class LowTankException extends RuntimeException{

    public LowTankException(String message) {
        super(message);
    }
}
