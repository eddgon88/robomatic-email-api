package cl.robomatic.email.v1.exceptions;

public class BusinessErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Integer status;
    private final String code;
    private final String message;

    public BusinessErrorException(final Integer status, final String code, final String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
