package cl.robomatic.email.v1.exceptions.messages;

public enum BadGatewayErrorCode {

    E502002("502002", "Failed connecting API sendgrid");

    private String code;
    private String message;

    BadGatewayErrorCode(final String code, final String message) {
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
