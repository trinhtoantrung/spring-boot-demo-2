package com.t3.spring.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/17/17 3:26 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Entity
@Table(name = "t_logdtl")
public class LogDetail implements Serializable{
  @Id
  @GeneratedValue
  @Column(name = "imx_un_id")
  private Long id;

  @Column(nullable = false)
  private String erreur;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name="id")
  @JsonBackReference
  private Log log;

  public LogDetail() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getErreur() {
    return erreur;
  }

  public void setErreur(String erreur) {
    this.erreur = erreur;
  }

  public Log getLog() {
    return log;
  }

  public void setLog(Log log) {
    this.log = log;
  }
}
