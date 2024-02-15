package com.aamir.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomeThymeleafException.class)
    private String handlerError(CustomeThymeleafException e){
        e.printStackTrace();
        return "notFound";
    }
}
