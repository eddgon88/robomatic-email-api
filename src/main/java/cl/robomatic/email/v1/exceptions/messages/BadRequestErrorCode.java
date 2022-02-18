package cl.robomatic.email.v1.exceptions.messages;

public enum BadRequestErrorCode {

    E400001("400001", "Topic is missing."),
    E400002("400002", "Data is missing."),
    E400003("400003", "NextTry is missing."),
    E400004("400004", "Retry date less than current date.");

    private String code;
    private String message;

    BadRequestErrorCode(final String code, final String message) {
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
