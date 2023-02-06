package org.example.exceptions;

public class SessionNotFoundException extends RuntimeException{

    public SessionNotFoundException(String exception) {
        super(exception);
    }
}
