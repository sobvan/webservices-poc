package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private Long id;

    @ApiModelProperty(required = true, example = "1982-12-18")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @ApiModelProperty(required = true, value = "Gender of the person. can be M and F", example = "M")
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

    public Person(Person other) {
        this(other.id, other.name, other.birthDate, other.gender);
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
