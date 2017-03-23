package com.t3.spring.boot.demo.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/23/17 1:37 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@ControllerAdvice
public class ControllerConfiguration {
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data sent to server")
  public void notValid(){
    // Do sth, log, send email, throw exception..
  }

}
