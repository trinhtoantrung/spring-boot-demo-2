package com.t3.spring.boot.demo.repository;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/22/17 3:30 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */
public class LogJpaRepositoryImpl implements LogJpaRepositoryCustom {
  @Override
  public void customMethod() {
    System.out.println("This is a custome method");
  }
}
