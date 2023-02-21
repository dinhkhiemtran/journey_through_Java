package main.exception.handle_exception;

import java.util.Optional;

public class ErrorHandling {
    public void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    public void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    public void handleErrorByThrowingAnyCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    public void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    public void handleErrorByThrowingAnyUncheckedException() {
        throw new CustomUncheckedException();
    }

    public void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    public void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    public void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    public void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    public void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    public Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
