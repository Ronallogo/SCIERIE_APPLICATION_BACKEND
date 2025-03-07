package com.scierie_application.scierie.handler.exeption;

public class RavitaillementLowCapacity extends RuntimeException {
    public RavitaillementLowCapacity(String message) {
        super(message);
    }
}
