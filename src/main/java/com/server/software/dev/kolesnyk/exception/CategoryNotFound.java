package com.server.software.dev.kolesnyk.exception;

public class CategoryNotFound extends EntityNotFound {
    public CategoryNotFound() {
        super();
    }

    public CategoryNotFound(String message) {
        super(message);
    }

    public CategoryNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFound(Throwable cause) {
        super(cause);
    }

    protected CategoryNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
