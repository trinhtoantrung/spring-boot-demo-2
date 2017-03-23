package com.t3.spring.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/17/17 3:25 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Entity
@Table(name = "t_log")
public class Log implements Serializable{
  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = "LOG_ID")
  @SequenceGenerator(name = "LOG_ID", sequenceName = "LOG_ID", allocationSize = 1)
  private Long id;

  @Column(name = "interface")
  @NotNull
  private String interfaceName;

  @Version
  private Date datetrait;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "log")
  @JsonManagedReference
  public List<LogDetail> logDetails;

  public Log() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName) {
    this.interfaceName = interfaceName;
  }

  public Date getDatetrait() {
    return datetrait;
  }

  public void setDatetrait(Date datetrait) {
    this.datetrait = datetrait;
  }

  public List<LogDetail> getLogDetails() {
    return logDetails;
  }

  public void setLogDetails(List<LogDetail> logDetails) {
    this.logDetails = logDetails;
  }
}
