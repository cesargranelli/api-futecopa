package com.sevenine.api.futecopa.exceptions;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception ex) {
        if (ex.getCause() instanceof FirebaseAuthException) {
            return handleFirebaseAuthException((FirebaseAuthException) ex.getCause());
        }
        return new ResponseEntity<>(new ApplicationErrorBody(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> handleFirebaseAuthException(FirebaseAuthException ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(ex.getErrorCode().name(), ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseBody
    @ExceptionHandler({IndexOutOfBoundsException.class})
    public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<>(new ApplicationErrorBody(HttpStatus.NOT_FOUND.name(), "Usuário não localizado"), HttpStatus.NOT_FOUND);
    }

}
