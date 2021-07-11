package com.schlumberger.app.exceptions;


class GenericExceptions extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GenericExceptions(String message) {
        super(message);
    }

    public GenericExceptions(String message, Throwable th) {
        super(message, th);
    }

}