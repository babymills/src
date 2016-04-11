package Procedure.dyn._4_double_lib;

/**
 * @author Mark created at: 21.06.14, 15:54
 */
public class NoSuchPositionException extends RuntimeException {
    public NoSuchPositionException() {
        super();
    }

    public NoSuchPositionException(String message) {
        super(message);
    }

    public NoSuchPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPositionException(Throwable cause) {
        super(cause);
    }

    protected NoSuchPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
