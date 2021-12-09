package uk.ac.cam.kjh67.q54;

public class EmailExtractionException extends Exception {
    private String errorMessage;
    EmailExtractionException(String message) {
        this.errorMessage = message;
    }
    public String getErrorMessage() { return errorMessage; }
}
