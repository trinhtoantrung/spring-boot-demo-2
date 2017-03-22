package com.t3.spring.boot.demo.controller;

import com.t3.spring.boot.demo.model.Log;
import com.t3.spring.boot.demo.model.LogDetail;
import com.t3.spring.boot.demo.repository.LogDetailJpaRepository;
import com.t3.spring.boot.demo.repository.LogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    return log;
  }

  @RequestMapping(value = "log", method = RequestMethod.POST)
  public Log createLog1(@RequestBody Log log) {
    return logJpaRepository.saveAndFlush(log);
  }

  @RequestMapping(value = "log", method = RequestMethod.PATCH)
  public Log updateLog1(@RequestBody Log log) {
    Log existedLog = logJpaRepository.findOne(log.getId());
    List<LogDetail> newLogDetails = new ArrayList<>();

    if (existedLog != null) {
      if (log.getInterfaceName() != null) {
        existedLog.setInterfaceName(log.getInterfaceName());
      }

      if (log.getLogDetails() != null) {
        for (LogDetail logDetail : log.getLogDetails()) {
          if (logDetail.getId() != null) {
            LogDetail newLogDetail = logDetailJpaRepository.findOne(logDetail.getId());
            if (newLogDetail != null) {
              newLogDetails.add(newLogDetail);
            }
          }
        }

        existedLog.setLogDetails(newLogDetails);
      }
      else {
        existedLog.setLogDetails(null);
      }

      logJpaRepository.saveAndFlush(existedLog);
    }

    return existedLog;
  }

  @RequestMapping(value = "log/{id}", method = RequestMethod.DELETE)
  public Log deleleLog1(@PathVariable Long id) {
    Log log = logJpaRepository.findOne(id);
    logJpaRepository.delete(id);
    return log;
  }

  @RequestMapping(value = "log-detail/{id}", method = RequestMethod.GET)
  public LogDetail getLogDetail1(@PathVariable Long id) {
    LogDetail logDetail = logDetailJpaRepository.findOne(id);
    return logDetail;
  }

  @RequestMapping(value = "log-detail", method = RequestMethod.POST)
  public LogDetail createLog1(@RequestBody LogDetail logDetail) {
    return logDetailJpaRepository.saveAndFlush(logDetail);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @RequestMapping(value = "log/findLogByInterfaceLike", method = RequestMethod.GET)
  public List<Log> findLogByInterfaceLike(@RequestParam(value = "interface") String interfaceName) {
    return logJpaRepository.findByInterfaceNameLike("%" + interfaceName + "%");
  }

  @PreAuthorize("hasRole('ROLE_USER')")
  @RequestMapping(value = "log/queryByInterfaceNameLike", method = RequestMethod.GET)
  public List<Log> queryLogByInterfaceLike(@RequestParam(value = "interface") String interfaceName) {
    return logJpaRepository.queryByInterfaceNameLike(interfaceName);
  }

  @RequestMapping(value = "log/nativeQueryByInterfaceNameLike", method = RequestMethod.GET)
  public List<Log> nativeQueryByInterfaceNameLike(@RequestParam(value = "interface") String interfaceName) {
    return logJpaRepository.nativeQueryByInterfaceLike(interfaceName);
  }
}
