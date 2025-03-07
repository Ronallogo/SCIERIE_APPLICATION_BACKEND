package com.scierie_application.scierie.handler.exeption;

public class PaysNotFoundException extends RuntimeException {
    public PaysNotFoundException(String message) {
        super(message);
    }

}
