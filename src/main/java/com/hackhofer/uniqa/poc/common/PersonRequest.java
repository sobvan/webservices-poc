package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonRequest extends Person {

    @Override
    @JsonIgnore
    public void setDbId(Long dbId) {
        super.setDbId(dbId);
    }
}
