package com.fundly.sdk.java.api;

import com.fundly.sdk.java.env.EnvironmentConstants;
import com.fundly.sdk.java.model.Authenticate;
import com.fundly.sdk.java.model.AuthenticateToken;
import com.fundly.sdk.java.model.FundlyConfig;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

@Slf4j
public class AuthenticateAPI {
    public AuthenticateToken getAuthenticationToken(FundlyConfig fundlyConfig ) {
        Authenticate authenticate = Authenticate.builder()
                .username(fundlyConfig.getUserName())
                .password(fundlyConfig.getPassword())
                .build();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        log.info("Body JSON[{}]", new Gson().toJson(authenticate));
        RequestBody body = RequestBody.create(new Gson().toJson(authenticate), JSON);
        String baseURL = fundlyConfig.getEnvironment().getValue().equalsIgnoreCase("SANDBOX") ?
                EnvironmentConstants.SANDBOX_URL : EnvironmentConstants.PRODUCTION_URL;
        String authenticateUrl = baseURL + "/token/authenticate";
        log.info("Fundly Authentication url [{}]", authenticateUrl);

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(authenticateUrl)
                .method("POST", body)
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            String responseFromFundly = response.body().string();
            log.info("Response from signzy [{}]", responseFromFundly);
            response.close();
            AuthenticateToken authenticateToken =
                    new Gson().fromJson(responseFromFundly, AuthenticateToken.class);
            log.info("Response from signzy [{}]", authenticateToken);
            return authenticateToken;
        } catch (Exception e) {
            String error = "Error occurred while processing your request";
            log.error("Error occurred while processing your request [{}]", e);
            return null;
        }
    }
}
