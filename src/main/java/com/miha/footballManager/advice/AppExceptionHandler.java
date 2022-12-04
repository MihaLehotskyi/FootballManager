package com.miha.footballManager.advice;

import com.miha.footballManager.exception.CustomFirstCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerInvalidArgument(){
        Map<String,String> errormap = new HashMap<>();
        errormap.put("age","Вік повинен бути в діапазоні від 18 до 60!");
        errormap.put("comission","Комісія повинна бути в діапазоні від 1 до 10%!");
        return errormap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> handlerInvalidId(){
        Map<String,String> errormap = new HashMap<>();
        errormap.put("error message","Немає елемента з таким id!");
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomFirstCaseException.class)
    public Map<String,String> handlerFirstCase(CustomFirstCaseException ex){
        Map<String,String> errormap = new HashMap<>();
        errormap.put("error message",ex.getMessage());
        return errormap;
    }
}
