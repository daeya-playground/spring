package kr.playground.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.playground.exception.MemoNotFoundException;
import kr.playground.exception.MemoValidationException;

@RestControllerAdvice
public class MemoApiExceptionHandler {

    @ExceptionHandler(MemoValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidation(MemoValidationException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return error;
    }

    @ExceptionHandler(MemoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(MemoNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return error;
    }
}
