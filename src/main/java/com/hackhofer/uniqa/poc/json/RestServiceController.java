package com.hackhofer.uniqa.poc.json;

import com.hackhofer.uniqa.poc.common.Person;
import com.hackhofer.uniqa.poc.common.PersonRepository;
import com.hackhofer.uniqa.poc.common.RequestLog;
import com.hackhofer.uniqa.poc.common.RequestLogRepository;
import com.hackhofer.uniqa.poc.common.ServiceType;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Services for Persons
 */
@RestController
public class RestServiceController {

    Logger logger = LoggerFactory.getLogger(RestServiceController.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RequestLogRepository requestLogRepository;

    @RequestMapping(value = "/KVFirstCare/application", method = RequestMethod.POST)
    public ApplicationResult application(@RequestBody List<Person> persons, HttpServletResponse response) {
        ApplicationResult result = new ApplicationResult();

        persons.stream().forEach(p -> {
            result.addName(p.getName() + "x");
            personRepository.save(p);

            RequestLog log = new RequestLog();
            log.setDate(new Date());
            log.setConcerningPerson(new Person(p.getId()));
            log.setServiceType(ServiceType.JSON);
            requestLogRepository.save(log);

            int birthYear = new DateTime(p.getBirthDate()).getYear();

            if (birthYear <1975) {
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                log.setResult("406");
            } else {
                log.setResult("OK");
            }

            if (birthYear == 2010) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    logger.error("Waiting aborted", e);
                }
            }
        });

        return result;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getPersons() {
        List<Person> result = new ArrayList<>();
        personRepository.findAll().forEach(result::add);
        return result;
    }

    @RequestMapping(value = "/requestlogs", method = RequestMethod.GET)
    public List<RequestLog> getAllRequestLog() {
        List<RequestLog> result = new ArrayList<>();
        requestLogRepository.findAll().forEach(result::add);
        return result;
    }


}