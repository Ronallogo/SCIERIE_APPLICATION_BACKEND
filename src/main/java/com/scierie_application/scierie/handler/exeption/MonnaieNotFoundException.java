package com.scierie_application.scierie.handler.exeption;

public class MonnaieNotFoundException extends RuntimeException {
    public MonnaieNotFoundException(String message) {
        super(message);
    }

}
