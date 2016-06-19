package com.hackhofer.uniqa.poc.common;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 * Person repository
 */

public interface PersonRepository extends CrudRepository<Person, Long> {
}
