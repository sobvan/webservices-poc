package com.hackhofer.uniqa.poc.common;

import java.util.List;

/**
 * Created by istvan on 13/07/16.
 */
public class PersonListResult {
    List<Person> persons = null;

    public PersonListResult() {
    }

    public PersonListResult(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
