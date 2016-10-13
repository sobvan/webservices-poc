package com.hackhofer.uniqa.poc.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * Response of the contract calculation API call
 */
public class ContractCalculateResponse {

    @ApiModelProperty(value = "The yearly premium calculated for the insurance.", example = "100000")
    private Double premium;

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }
}
