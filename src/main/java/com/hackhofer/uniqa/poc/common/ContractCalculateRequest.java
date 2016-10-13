package com.hackhofer.uniqa.poc.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * Request Object for calculating
 */
public class ContractCalculateRequest {

    @ApiModelProperty(required = true)
    ContractCalculateRequestBody request;

    public ContractCalculateRequestBody getRequest() {
        return request;
    }

    public void setRequest(ContractCalculateRequestBody request) {
        this.request = request;
    }
}
