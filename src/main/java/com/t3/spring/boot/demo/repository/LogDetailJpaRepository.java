package com.t3.spring.boot.demo.repository;

import com.t3.spring.boot.demo.model.LogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creation of spring-boot-demo-2.
 * <p/>
 * Created by tttrinh
 * Created date 3/20/17 11:11 AM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Repository
public interface LogDetailJpaRepository extends JpaRepository<LogDetail, Long>{
}
