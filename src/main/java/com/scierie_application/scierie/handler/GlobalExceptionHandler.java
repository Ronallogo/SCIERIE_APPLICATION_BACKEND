package com.scierie_application.scierie.handler;



import com.scierie_application.scierie.handler.exeption.ContratNotFoundException;
import com.scierie_application.scierie.handler.exeption.EssenceNotFoundException;
import com.scierie_application.scierie.handler.exeption.GrumeNotFoundException;
import com.scierie_application.scierie.handler.exeption.MonnaieNotFoundException;
import com.scierie_application.scierie.handler.exeption.PaysNotFoundException;
import com.scierie_application.scierie.handler.exeption.PortNotFoundException;
import com.scierie_application.scierie.handler.exeption.RavitaillementNotFoundException;
import com.scierie_application.scierie.handler.exeption.SocieteNotFoundException;
import com.scierie_application.scierie.handler.exeption.TraitementNotFoundException;
import com.scierie_application.scierie.handler.exeption.TypePaiementNotFoundException;
import com.scierie_application.scierie.handler.exeption.VilleNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


// Controller Advice for handle all Exception
@ControllerAdvice
public class GlobalExceptionHandler {
    ////////////////////////////////  Exception Essence Handler   //////////////////////////////////////
    @ExceptionHandler(EssenceNotFoundException.class)
    public ResponseEntity<?> handleEssenceNotFoundException(EssenceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

//////////////////////////////  Exception Monnaie Handler   //////////////////////////////////////
    @ExceptionHandler(MonnaieNotFoundException.class)
    public ResponseEntity<?> handleAbsenceNotFoundException(MonnaieNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    ////////////////////////////////  Exception Global Handler   //////////////////////////////////////
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    ////////////////////////////////  Exception Port Handler   //////////////////////////////////////

    @ExceptionHandler(PortNotFoundException.class )
    public ResponseEntity<?> handlePortNotFoundException(PortNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    ////////////////////////////////  Exception Pays Handler   //////////////////////////////////////

    @ExceptionHandler(PaysNotFoundException.class )
    public ResponseEntity<?> handlePaysNotFoundException(PaysNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
//////////////////////////////  Exception Ville Handler   //////////////////////////////////////
    
    @ExceptionHandler(VilleNotFoundException.class )
    public ResponseEntity<?> handleVilleNotFoundException(VilleNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
//  ////////////////////////////////  Exception Grume Handler   //////////////////////////////////////

    @ExceptionHandler(ContratNotFoundException.class )
    public ResponseEntity<?> handleContratNotFoundException(ContratNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//////////////////////////////  Exception Societe Handler   //////////////////////////////////////   
    @ExceptionHandler(SocieteNotFoundException.class )
    public ResponseEntity<?> handleSocieteNotFoundException(SocieteNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
//////////////////////////////  Exception Traitement Handler   //////////////////////////////////////
    @ExceptionHandler(TraitementNotFoundException.class )
    public ResponseEntity<?> handleTraitementNotFoundException(TraitementNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//////////////////////////////  Exception Grume Handler   //////////////////////////////////////
    @ExceptionHandler(GrumeNotFoundException.class )
    public ResponseEntity<?> handleGrumeNotFoundException(GrumeNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   
//////////////////////////////  Exception Ravitaillement Handler   //////////////////////////////////////
    @ExceptionHandler(RavitaillementNotFoundException.class )
    public ResponseEntity<?> handleRavitaillementNotFoundException(RavitaillementNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } 

    //////////////////////////////  Exception TypePaiement Handler   //////////////////////////////////////
    @ExceptionHandler(TypeNotPresentException.class )
    public ResponseEntity<?> handleTypePaiementNotFoundException( TypePaiementNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } 




}
