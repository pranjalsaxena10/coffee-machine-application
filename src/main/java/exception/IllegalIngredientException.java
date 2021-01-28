package exception;

/**
 * This is implemented to have custom exception
 */
public class IllegalIngredientException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IllegalIngredientException(String message) {
        super(message);
    }
}
