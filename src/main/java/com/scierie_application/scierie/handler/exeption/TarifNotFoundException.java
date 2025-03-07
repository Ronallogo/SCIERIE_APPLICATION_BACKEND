package com.scierie_application.scierie.handler.exeption;

public class TarifNotFoundException extends RuntimeException {
    public TarifNotFoundException(String message) {
        super(message);
    }
}
