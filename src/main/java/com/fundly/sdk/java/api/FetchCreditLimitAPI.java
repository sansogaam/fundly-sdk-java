package com.fundly.sdk.java.api;

import com.fundly.sdk.java.env.EnvironmentConstants;
import com.fundly.sdk.java.model.AuthenticateToken;
import com.fundly.sdk.java.model.CreditLimit;
import com.fundly.sdk.java.model.ERPRetailerKey;
import com.fundly.sdk.java.model.FundlyConfig;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

@Slf4j
public class FetchCreditLimitAPI {
    FundlyConfig fundlyConfig;
    public FetchCreditLimitAPI(FundlyConfig fundlyConfig) {
        this.fundlyConfig = fundlyConfig;
    }


    public CreditLimit getCreditLimit(ERPRetailerKey erpRetailerKey) {
        AuthenticateAPI authenticateAPI = new AuthenticateAPI();
        AuthenticateToken token = authenticateAPI.getAuthenticationToken(fundlyConfig);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        log.info("Body JSON[{}]", new Gson().toJson(erpRetailerKey));
        RequestBody body = RequestBody.create(new Gson().toJson(erpRetailerKey), JSON);
        String baseURL = fundlyConfig.getEnvironment().getValue().equalsIgnoreCase("SANDBOX") ?
                EnvironmentConstants.SANDBOX_URL : EnvironmentConstants.PRODUCTION_URL;
        String creditLimitUrl = baseURL + "/erp/creditlimit";
        log.info("Fundly Credit Limit url [{}]", creditLimitUrl);
        okhttp3.Request request = new okhttp3.Request.Builder()
                .addHeader("Authorization", "Bearer " + token.getJwttoken())
                .url(creditLimitUrl)
                .method("POST", body)
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            String responseFromFundly = response.body().string();
            log.info("Response from signzy [{}]", responseFromFundly);
            response.close();
            CreditLimit creditLimit =
                    new Gson().fromJson(responseFromFundly, CreditLimit.class);
            log.info("Response from signzy [{}]", creditLimit);
            return creditLimit;
        } catch (Exception e) {
            String error = "Error occurred while processing your request";
            log.error("Error occurred while processing your request [{}]", e);
            return null;
        }
    }
}
