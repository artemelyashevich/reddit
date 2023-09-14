package com.elyashevich.reddit.exception;

public class CommunityException extends RuntimeException{

    public CommunityException() {
    }

    public CommunityException(String message) {
        super(message);
    }

    public CommunityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunityException(Throwable cause) {
        super(cause);
    }

    public CommunityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
