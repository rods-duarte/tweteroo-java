package com.tweteroo.api.exceptions;

public class InvalidUserAvatarException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidUserAvatarException(String message) {
        super(message);
    }
}
