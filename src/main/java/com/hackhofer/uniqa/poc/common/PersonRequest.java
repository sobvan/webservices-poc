package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackhofer.uniqa.poc.common.Person;

public class PersonRequest extends Person {

    @Override
    @JsonIgnore
    public void setDbId(Long dbId) {
        super.setDbId(dbId);
    }
}
