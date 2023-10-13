package com.fundly.sdk.java.model;

import com.fundly.sdk.java.env.Environment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FundlyConfig {
    private String userName;
    private String password;
    private Environment environment;
}
