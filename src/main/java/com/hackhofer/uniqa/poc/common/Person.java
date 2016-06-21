package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

/**
 * Simple Person pojo
 */
@Entity
public class Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long dbId;
    private String name;

    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private String gender;

    public Person() {
    }

    public Person(long dbId) {
        this.dbId = dbId;
    }

    public Person(Long id, String name, Date birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Long getDbId() {
        return dbId;
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

    public void setDbId(Long dbId) {
        this.dbId = dbId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
