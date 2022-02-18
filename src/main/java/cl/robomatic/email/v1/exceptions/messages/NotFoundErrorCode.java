package cl.robomatic.email.v1.exceptions.messages;

public enum NotFoundErrorCode {

    E404001("404001", "Topic not found."),
    E404002("404002", "Retry status not found.");

    private String code;
    private String message;

    NotFoundErrorCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    }
