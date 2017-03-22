package com.t3.spring.boot.demo.repository;

import com.t3.spring.boot.demo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface LogJpaRepository extends JpaRepository<Log, Long>{
  // Query DSL
  public List<Log> findByInterfaceNameLike(String interfaceName);

  @Query("select log from Log log where log.interfaceName like %?1")
  public List<Log> queryByInterfaceNameLike(String interfaceName);
}
