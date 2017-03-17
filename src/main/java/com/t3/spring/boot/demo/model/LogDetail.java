package com.t3.spring.boot.demo.model;

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
}
