package com.hackhofer.uniqa.poc.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Result for application json service
 */
public class ApplicationResult {
    List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void addName(String name) {
        names.add(name);
    }
}
