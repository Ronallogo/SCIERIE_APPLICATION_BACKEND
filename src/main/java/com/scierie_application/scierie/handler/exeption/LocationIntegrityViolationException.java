package com.scierie_application.scierie.handler.exeption;

import org.springframework.dao.DataIntegrityViolationException;

public class LocationIntegrityViolationException  extends DataIntegrityViolationException {
    public LocationIntegrityViolationException(String msg) {
        super(msg);
    }
}
