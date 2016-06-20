package com.hackhofer.uniqa.poc.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Result for application json service
 */
public class ApplicationResult {
    private List<IdNamePair> idNamePairs = new ArrayList<>();

    public List<IdNamePair> getNames() {
        return idNamePairs;
    }

    public void setNames(List<IdNamePair> idNamePairs) {
        this.idNamePairs = idNamePairs;
    }

    public void add(IdNamePair idNamePair) {
        idNamePairs.add(idNamePair);
    }
}
