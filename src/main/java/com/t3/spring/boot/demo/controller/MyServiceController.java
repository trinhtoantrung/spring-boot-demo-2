package com.t3.spring.boot.demo.controller;

import com.t3.spring.boot.demo.model.Log;
import com.t3.spring.boot.demo.model.LogDetail;
import com.t3.spring.boot.demo.repository.LogDetailJpaRepository;
import com.t3.spring.boot.demo.repository.LogJpaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/20/17 11:17 AM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RestController
@RequestMapping("my-service/")
public class MyServiceController {

  @Autowired
  private LogJpaRepository logJpaRepository;

  @Autowired
  private LogDetailJpaRepository logDetailJpaRepository;

  @RequestMapping(value = "log/{id}", method = RequestMethod.GET)
  public Log getLogById1(@PathVariable Long id) {
    Log log = logJpaRepository.findOne(id);
    Hibernate.initialize(log);
    return log;
  }

  @RequestMapping(value = "log/", method = RequestMethod.POST)
  public Log createLog1(@RequestBody Log log) {
    return logJpaRepository.saveAndFlush(log);
  }

  @RequestMapping(value = "log/", method = RequestMethod.PATCH)
  public Log updateLog1(@RequestBody Log log) {
    if (logJpaRepository.findOne(log.getId()) != null) {
      return logJpaRepository.saveAndFlush(log);
    }
    return null;
  }

  @RequestMapping(value = "log/{id}", method = RequestMethod.DELETE)
  public Log deleleLog1(@PathVariable Long id) {
    Log log = logJpaRepository.findOne(id);
    logJpaRepository.delete(id);
    return log;
  }

  @RequestMapping(value = "log-detail/{id}", method = RequestMethod.GET)
  public LogDetail getLogDetail1(@PathVariable Long id) {
    LogDetail logDetail = logDetailJpaRepository.getOne(id);
    Hibernate.initialize(logDetail);
    return logDetail;
  }
}
