package com.sevenine.api.futecopa.exceptions;

import com.sevenine.api.futecopa.datasources.firestore.exceptions.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception ex) {
        if (ex.getCause() instanceof HttpClientErrorException) {
            return handleHttpClientErrorException((HttpClientErrorException) ex.getCause());
        } else if (ex.getCause() instanceof NoSuchElementException) {
            return handleNoSuchElementException((NoSuchElementException) ex.getCause());
        } else if (ex.getCause() instanceof FirebaseAuthException) {
            return handleFirebaseAuthException((FirebaseAuthException) ex.getCause());
        }
        return new ResponseEntity<>(new ApplicationErrorBody(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(ex.getLocalizedMessage(), ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private ResponseEntity<?> handleNoSuchElementException(NoSuchElementException ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(ex.getMessage(), ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private ResponseEntity<?> handleFirebaseAuthException(FirebaseAuthException ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(String.valueOf(ex.getError().getCode()), ex.getError().getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler({IndexOutOfBoundsException.class})
    public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(HttpStatus.NOT_FOUND.name(), "Usuário não localizado"), HttpStatus.NOT_FOUND);
    }

}
