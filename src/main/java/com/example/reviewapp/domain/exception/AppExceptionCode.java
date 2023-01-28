package com.example.reviewapp.domain.exception;

public enum AppExceptionCode {
    INVALID_EMAIL("Invalid email.", 400),
    NO_SUCH_USER("There is no such user with passed uuid.", 400),
    NO_SUCH_PRODUCT("There is no such product. ", 400);

    private final String message;
    private final int status;

    AppExceptionCode(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public DomainException createException() {
        return new DomainException(this);
    }
}

