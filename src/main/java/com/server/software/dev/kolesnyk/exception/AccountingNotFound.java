package com.server.software.dev.kolesnyk.exception;

public class AccountingNotFound extends EntityNotFound {
    public AccountingNotFound() {
        super();
    }

    public AccountingNotFound(String message) {
        super(message);
    }

    public AccountingNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountingNotFound(Throwable cause) {
        super(cause);
    }

    protected AccountingNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
