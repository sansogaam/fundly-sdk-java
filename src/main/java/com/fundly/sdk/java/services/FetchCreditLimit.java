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
    public CreditLimit getCreditLimit(ERPRetailerKey erpRetailerKey){
        FetchCreditLimitAPI fetchCreditLimitAPI = new FetchCreditLimitAPI(fundlyConfig);
        return fetchCreditLimitAPI.getCreditLimit(erpRetailerKey);
    }
    public static void main(String[] args) {
        FundlyConfig fundlyConfig = FundlyConfig.builder()
                .userName("wonderSoft")
                .password("password")
                .environment(Environment.SANDBOX)
                .build();
        FetchCreditLimit fetchCreditLimit = new FetchCreditLimit(fundlyConfig);
        ERPRetailerKey  erpRetailerKey= ERPRetailerKey.builder()
                .erpId(100001)
                .erpRetailerId(1)
                .retailerId(357)
                .build();
        CreditLimit creditLimit = fetchCreditLimit.getCreditLimit(erpRetailerKey);
        System.out.println(creditLimit);
    }
}
