package com.hackhofer.uniqa.poc.common;

import org.springframework.data.repository.CrudRepository;

/**
 * Person repository
 */

public interface PersonRepository extends CrudRepository<Person, Long> {
}
