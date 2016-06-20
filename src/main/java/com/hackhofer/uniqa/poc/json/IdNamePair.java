package com.hackhofer.uniqa.poc.json;

/**
 * Created by istvan on 20/06/16.
 */
public class IdNamePair {
    private Long id;
    private String name;

    public IdNamePair() {
    }

    public IdNamePair(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
