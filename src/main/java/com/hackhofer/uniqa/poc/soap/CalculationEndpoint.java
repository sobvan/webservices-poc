package com.hackhofer.uniqa.poc.soap;

import com.hackhofer.uniqa.poc.common.Person;
import com.hackhofer.uniqa.poc.common.PersonRepository;
import com.hackhofer.uniqa.poc.common.RequestLog;
import com.hackhofer.uniqa.poc.common.RequestLogRepository;
import com.hackhofer.uniqa.poc.common.ServiceType;
import com.hackhofer.uniqapoc.CalculateRequest;
import com.hackhofer.uniqapoc.CalculateResponse;
import com.hackhofer.uniqapoc.OneCacluateRepsonse;
import com.hackhofer.uniqapoc.Soapperson;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Date;

/**
 * Webservice Endpoint for Country service
 */
@Endpoint
public class CalculationEndpoint {

    public static final String NAMESPACE_URI = "http://hackhofer.com/uniqaPoc";
    private static final Logger logger = LoggerFactory.getLogger(CalculationEndpoint.class);
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RequestLogRepository requestLogRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculateRequest")
    @ResponsePayload
    public CalculateResponse getCountry(@RequestPayload CalculateRequest request) throws Exception {
        CalculateResponse response = new CalculateResponse();

        for(Soapperson p : request.getPerson()) {
            try {
                OneCacluateRepsonse oneResponse = new OneCacluateRepsonse();
                oneResponse.setId(p.getId());
                Date today = new Date();
                Date birthDay = p.getBirthDate().toGregorianCalendar().getTime();
                if (birthDay.compareTo(today) > 0
                    || p.getBirthDate().getYear() < 1900) {
                    oneResponse.setReturnCode((short) 1);
                    oneResponse.setErrorMessage("Birthdate should be before today and after 1900");
                } else if (p.getBirthDate().getYear() < 1970) {
                    throw new InvalidDateException("InvalidDateException - Birthday should be after 1970 - person id: " + p.getId());
                } else if (p.getGender() == null) {
                    oneResponse.setReturnCode((short) 2);
                    oneResponse.setErrorMessage("Gender can only be \"F\" and \"M\"");
                } else {
                    oneResponse.setPremiumAmount(getPremAmount(p));
                    oneResponse.setReturnCode((short) 0);
                }
                response.getCalculateResponse().add(oneResponse);

                Person pers = savePerson(p);
                createLogEntry(pers, "" + oneResponse.getReturnCode());
            } catch (InvalidDateException e) {
                throw e;
            } catch (Exception ex) {
                logger.error("Error while processing soap request", ex);
            }
        }

        logger.info("Serving calculate request.");
        return response;
    }

    private Person savePerson(Soapperson p) {
        Person pers = new Person(p.getId(),
                                 p.getName(),
                                 p.getBirthDate().toGregorianCalendar().getTime(),
                                 p.getGender() == null ? null : p.getGender().value());
        return personRepository.save(pers);
    }

    private void createLogEntry(Person p, String s) {
        RequestLog log = new RequestLog();
        log.setDate(new Date());
        log.setConcerningPerson(new Person(p.getId()));
        log.setServiceType(ServiceType.SOAP);
        log.setResult(s);
        requestLogRepository.save(log);
    }

    private int getPremAmount(Soapperson p) {
        DateTime birthDate = new DateTime(p.getBirthDate().toGregorianCalendar().getTime());
        return Years.yearsBetween(birthDate, new DateTime()).getYears() * 100;
    }
}
