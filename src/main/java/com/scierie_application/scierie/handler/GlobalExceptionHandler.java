package com.scierie_application.scierie.handler;



import com.scierie_application.scierie.handler.exeption.ContratNotFoundException;
import com.scierie_application.scierie.handler.exeption.EssenceNotFound;
import com.scierie_application.scierie.handler.exeption.MonnaieNotFoundException;
import com.scierie_application.scierie.handler.exeption.PaysNotFoundException;
import com.scierie_application.scierie.handler.exeption.PortNotFoundException;
import com.scierie_application.scierie.handler.exeption.SocieteNotFoundException;
import com.scierie_application.scierie.handler.exeption.VilleNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


// Controller Advice for handle all Exception
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EssenceNotFound.class)
    public ResponseEntity<?> handleEssenceNotFoundException(EssenceNotFound ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MonnaieNotFoundException.class)
    public ResponseEntity<?> handleAbsenceNotFoundException(MonnaieNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PortNotFoundException.class )
    public ResponseEntity<?> handlePortNotFoundException(PortNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaysNotFoundException.class )
    public ResponseEntity<?> handlePaysNotFoundException(PaysNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(VilleNotFoundException.class )
    public ResponseEntity<?> handleVilleNotFoundException(VilleNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ContratNotFoundException.class )
    public ResponseEntity<?> handleContratNotFoundException(ContratNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(SocieteNotFoundException.class )
    public ResponseEntity<?> handleSocieteNotFoundException(SocieteNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
