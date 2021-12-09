package uk.ac.cam.kjh67.q55;

public class NewtonRaphsonException extends Exception {
    private String errorMessage;
    NewtonRaphsonException(String message) {
        errorMessage = message;
    }
    public String getErrorMessage() {
        return String.format("Newton Raphson Error: %s", errorMessage);
    }
}
