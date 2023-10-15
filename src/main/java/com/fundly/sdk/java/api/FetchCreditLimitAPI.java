package com.fundly.sdk.java.api;

import com.fundly.sdk.java.model.AuthenticateToken;
import com.fundly.sdk.java.model.FundlyConfig;

public class FetchCreditLimitAPI {
    FundlyConfig fundlyConfig;
    public FetchCreditLimitAPI(FundlyConfig fundlyConfig) {
        this.fundlyConfig = fundlyConfig;
    }


    public void getCreditLimit(String erpName, String erpCustomerId) {
        AuthenticateAPI authenticateAPI = new AuthenticateAPI();
        AuthenticateToken token = authenticateAPI.getAuthenticationToken(fundlyConfig);
    }
}
