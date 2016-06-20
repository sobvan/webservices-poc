package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Simple Person pojo
 */
@Entity
public class Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private String gender;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(String name, Date birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }


    public Integer getAge() {
        return Years.yearsBetween(new DateTime(birthDate), new DateTime()).getYears();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
