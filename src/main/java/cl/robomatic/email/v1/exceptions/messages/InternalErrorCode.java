package cl.robomatic.email.v1.exceptions.messages;

public enum InternalErrorCode {

    E500000("500000", "Unexpected error."),
    E500001("500001", "Couldn't send or receive message from Queue."),
    E500002("500002", "Parameter can not be null or it is an invalid one."),
    E500003("500003", "Error parsing LocalDateTime");


    private String code;
    private String message;

    InternalErrorCode(final String code, final String message) {
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
