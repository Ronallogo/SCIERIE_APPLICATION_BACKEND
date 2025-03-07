package com.scierie_application.scierie.handler;



import com.scierie_application.scierie.handler.exeption.*;

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

    //////////////////////////////  Exception RavitaillementLowCapacity Handler   //////////////////////////////////////
    @ExceptionHandler(RavitaillementLowCapacity.class )
    public ResponseEntity<?> handleRavitaillementLowCapacityException( RavitaillementLowCapacity ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //////////////////////////////  Exception ClientNotFoundException Handler   //////////////////////////////////////
    @ExceptionHandler(ClientNotFoundException.class )
    public ResponseEntity<?> handleClientNotFoundException( ClientNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //////////////////////////////  Exception  TarifNotFoundException Handler   //////////////////////////////////////
    @ExceptionHandler( TarifNotFoundException.class )
    public ResponseEntity<?> handleTarifNotFoundException(  TarifNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //////////////////////////////  Exception  TarifNotFoundException Handler   //////////////////////////////////////
    @ExceptionHandler(  LocationIntegrityViolationException.class )
    public ResponseEntity<?> handleLocationIntegrityException(  LocationIntegrityViolationException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }





}
