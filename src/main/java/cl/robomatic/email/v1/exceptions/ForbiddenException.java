package cl.robomatic.email.v1.exceptions;


import cl.robomatic.email.v1.exceptions.messages.ForbiddenErrorCode;

public class ForbiddenException extends BusinessErrorException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException(final String code, final String message) {
        super(403, code, message);
    }

    public ForbiddenException(final ForbiddenErrorCode forbiddenErrorCode) {
        this(forbiddenErrorCode.getCode(), forbiddenErrorCode.getMessage());
    }

    public ForbiddenException(final ForbiddenErrorCode forbiddenErrorCode, final String customMessage) {
        this(forbiddenErrorCode.getCode(), customMessage);
    }
}
