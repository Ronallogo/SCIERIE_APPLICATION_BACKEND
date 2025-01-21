package com.scierie_application.scierie.handler;



import com.scierie_application.scierie.handler.exeption.EssenceNotFound;
import com.scierie_application.scierie.handler.exeption.MonnaieNotFoundException;
import com.scierie_application.scierie.handler.exeption.PortNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


// Controller Advice for handle all Exception
@ControllerAdvice
public class GlobalExceptionHandler {
    /////endpoint exception for employee not found
  /*  @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    /////endpoint exception for position not found
    @ExceptionHandler(PositionNotFoundException.class)
    public ResponseEntity<?> handlePositionNotFoundException(PositionNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    ////endpoint exception for task not found
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



    ////endpoint exception for task_inserted not found
    @ExceptionHandler(TaskInsertedNotFoundException.class)
    public ResponseEntity<?> handleTaskInsertedNotFoundException(TaskInsertedNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    ////endpoint exception for task_scheduled not found
    @ExceptionHandler(TaskScheduledNotFoundException.class)
    public ResponseEntity<?> handleTaskScheduledNotFoundException(TaskScheduledNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



    ////endpoint exception for payStub not found
    @ExceptionHandler(PayStubNotFoundException.class)
    public ResponseEntity<?> handlePayStubNotFoundException(PayStubNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



    ////endpoint exception for content not found
    @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<?> handleContentNotFoundException(ContentNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    ////endpoint exception for timeoff not found
    @ExceptionHandler(TimeOffNotFoundException.class)
    public ResponseEntity<?> handleTimeOffNotFoundException(TimeOffNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



    ////endpoint exception for absences not found
    @ExceptionHandler(AbsenceNotFoundException.class)
    public ResponseEntity<?> handleAbsenceNotFoundException(AbsenceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    /////endpoint for entity not found
  


    //////endpoints for unique taskInserted




    
*/
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


}
