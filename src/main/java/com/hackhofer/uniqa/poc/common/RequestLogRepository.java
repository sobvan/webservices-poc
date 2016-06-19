package com.hackhofer.uniqa.poc.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Default Repository for RequestLog
 */
public interface RequestLogRepository extends CrudRepository<RequestLog, Long> {

    @Query(value = "select rl from RequestLog rl join fetch rl.concerningPerson")
    List<RequestLog> findAll();

}
