package kr.playground.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.playground.exception.ApiException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, String>> handleApiException(ApiException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e) {
        String message = "입력값이 올바르지 않습니다";
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null && fieldError.getDefaultMessage() != null) {
            message = fieldError.getDefaultMessage();
        }
        Map<String, String> error = new HashMap<>();
        error.put("message", message);
        return ResponseEntity.badRequest().body(error);
    }
}
