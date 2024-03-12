package exception;

public class InvalidBoardDimensionException extends RuntimeException{
    public InvalidBoardDimensionException() {
        super();
    }

    public InvalidBoardDimensionException(String message) {
        super(message);
    }

    public InvalidBoardDimensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBoardDimensionException(Throwable cause) {
        super(cause);
    }

    protected InvalidBoardDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
