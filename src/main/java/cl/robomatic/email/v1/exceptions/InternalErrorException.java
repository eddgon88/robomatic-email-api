package cl.robomatic.email.v1.exceptions;


import cl.robomatic.email.v1.exceptions.messages.InternalErrorCode;

public class InternalErrorException extends BusinessErrorException {

    private static final long serialVersionUID = 1L;

    public InternalErrorException(final String code, final String message) {
        super(500, code, message);
    }

    public InternalErrorException(final InternalErrorCode internalErrorCode) {
        this(internalErrorCode.getCode(), internalErrorCode.getMessage());
    }

    public InternalErrorException(final InternalErrorCode internalErrorCode, final String customMessage) {
        this(internalErrorCode.getCode(), customMessage);
    }

}
