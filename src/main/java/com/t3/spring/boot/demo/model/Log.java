package com.t3.spring.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
  @GeneratedValue
  private Long id;

  @Column(name = "interface", nullable = false)
  private String interfaceName;

  @Temporal(TemporalType.TIMESTAMP)
  private Date datetrait;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "log")
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
}