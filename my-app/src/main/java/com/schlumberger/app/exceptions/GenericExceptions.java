package com.schlumberger.app.exceptions;


class GenericException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable th) {
        super(message, th);
    }

}