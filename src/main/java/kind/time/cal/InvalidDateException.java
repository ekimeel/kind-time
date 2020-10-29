package kind.time.cal;

/**
 * @author mlee
 */
public class InvalidDateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;

    public InvalidDateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }


}
