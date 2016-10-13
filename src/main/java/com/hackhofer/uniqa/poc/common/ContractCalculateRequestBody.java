package com.hackhofer.uniqa.poc.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Request Object for calculating
 */
public class ContractCalculateRequestBody {

    @ApiModelProperty(required = true)
    Person insuredPerson;

    @ApiModelProperty(required = true, example = "2016-11-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractBeginDate;

    @ApiModelProperty(required = true, example = "2021-11-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractEndDate;

    @ApiModelProperty(required = true, example = "100000")
    private Double insuredSum;

    @ApiModelProperty(required = true, value = "Multiple of 10%. EG. 1=10%, 5=50%", example = "1")
    private Integer discount;

    public Person getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Person insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getInsuredSum() {
        return insuredSum;
    }

    public void setInsuredSum(Double insuredSum) {
        this.insuredSum = insuredSum;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
