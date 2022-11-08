package com.server.software.dev.kolesnyk.exception;

public class RecordNotFound extends EntityNotFound {
    public RecordNotFound() {
        super();
    }

    public RecordNotFound(String message) {
        super(message);
    }

    public RecordNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotFound(Throwable cause) {
        super(cause);
    }

    protected RecordNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
