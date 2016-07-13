package com.hackhofer.uniqa.poc.common;

import java.util.List;

/**
 * Created by istvan on 13/07/16.
 */
public class PersonRequestList {
    List<PersonRequest> persons;

    public PersonRequestList() {
    }

    public PersonRequestList(List<PersonRequest> persons) {
        this.persons = persons;
    }

    public List<PersonRequest> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonRequest> persons) {
        this.persons = persons;
    }
}
