package main.exception.handle_exception;

public class CustomUncheckedException extends RuntimeException {
    CustomUncheckedException() {
        super();
    }

    CustomUncheckedException(String message) {
        super(message);
    }
}
