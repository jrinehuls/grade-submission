package com.jrinehuls.gradesubmission;


import com.jrinehuls.gradesubmission.exception.*;
import com.jrinehuls.gradesubmission.exception.notfound.CourseNotFoundException;
import com.jrinehuls.gradesubmission.exception.notfound.GradeNotFoundException;
import com.jrinehuls.gradesubmission.exception.notfound.ResourceNotFoundException;
import com.jrinehuls.gradesubmission.exception.notfound.StudentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class, CourseNotFoundException.class, GradeNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(ex.getMessage());
        ErrorResponse response = new ErrorResponse(messages);
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ArrayList<String> messages = new ArrayList<>();
        if (ex.getMessage().contains("Unique index or primary key violation")) {
            messages.add("Unique index or primary key violation");
        }
        messages.add(ex.getMessage());
        ErrorResponse response = new ErrorResponse(messages);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ArrayList<String> messages = new ArrayList<>();
        for (ObjectError error: ex.getBindingResult().getAllErrors()) {
            messages.add(error.getDefaultMessage());
        }
        return new ResponseEntity<>(new ErrorResponse(messages), HttpStatus.BAD_REQUEST);
    }
}
