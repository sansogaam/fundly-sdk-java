package com.fundly.sdk.java.services;

import com.fundly.sdk.java.api.FetchCreditLimitAPI;
import com.fundly.sdk.java.env.Environment;
import com.fundly.sdk.java.model.FundlyConfig;

public class FetchCreditLimit {
    FundlyConfig fundlyConfig;
    public FetchCreditLimit(FundlyConfig fundlyConfig){
        this.fundlyConfig = fundlyConfig;
    }
    public void getCreditLimit( String erpName, String erpCustomerId) {
        FetchCreditLimitAPI fetchCreditLimitAPI = new FetchCreditLimitAPI(fundlyConfig);
        fetchCreditLimitAPI.getCreditLimit(erpName, erpCustomerId);
    }
    public static void main(String[] args) {
        FundlyConfig fundlyConfig = FundlyConfig.builder()
                .userName("radheyKrishna")
                .password("password")
                .environment(Environment.SANDBOX)
                .build();
        FetchCreditLimit fetchCreditLimit = new FetchCreditLimit(fundlyConfig);
        fetchCreditLimit.getCreditLimit("erpName", "erpCustomerId");
    }
}
