package com.fundly.sdk.java.services;

import com.fundly.sdk.java.api.FetchCreditLimitAPI;
import com.fundly.sdk.java.env.Environment;
import com.fundly.sdk.java.model.CreditLimit;
import com.fundly.sdk.java.model.ERPRetailerKey;
import com.fundly.sdk.java.model.FundlyConfig;

public class FetchCreditLimit {
    FundlyConfig fundlyConfig;
    public FetchCreditLimit(FundlyConfig fundlyConfig){
        this.fundlyConfig = fundlyConfig;
    }
    public CreditLimit getCreditLimit(String erpName, String erpCustomerId) {
        FetchCreditLimitAPI fetchCreditLimitAPI = new FetchCreditLimitAPI(fundlyConfig);
        ERPRetailerKey  erpRetailerKey= ERPRetailerKey.builder()
                .erpId(1)
                .build();
        return fetchCreditLimitAPI.getCreditLimit(null);
    }
    public static void main(String[] args) {
        FundlyConfig fundlyConfig = FundlyConfig.builder()
                .userName("radheyKrishna")
                .password("password")
                .environment(Environment.SANDBOX)
                .build();
        FetchCreditLimit fetchCreditLimit = new FetchCreditLimit(fundlyConfig);
        CreditLimit creditLimit = fetchCreditLimit.getCreditLimit("erpName", "erpCustomerId");
        System.out.println(creditLimit);
    }
}
