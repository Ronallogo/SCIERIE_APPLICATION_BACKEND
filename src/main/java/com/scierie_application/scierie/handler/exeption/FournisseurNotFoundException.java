package com.scierie_application.scierie.handler.exeption;

public class FournisseurNotFoundException  extends RuntimeException{
    public FournisseurNotFoundException(String message) {
        super(message);
    }
}
