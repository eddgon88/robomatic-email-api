package cl.robomatic.email.v1.exceptions;


import cl.robomatic.email.v1.exceptions.messages.NotFoundErrorCode;

public class NotFoundException extends BusinessErrorException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(final String code, final String message) {
        super(404, code, message);
    }

    public NotFoundException(final NotFoundErrorCode notFoundErrorCode) {
        this(notFoundErrorCode.getCode(), notFoundErrorCode.getMessage());
    }

    public NotFoundException(final NotFoundErrorCode notFoundErrorCode, final String customMessage) {
        this(notFoundErrorCode.getCode(), customMessage);
    }

}
