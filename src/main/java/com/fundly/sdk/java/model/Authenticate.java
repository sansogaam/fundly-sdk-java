package com.fundly.sdk.java.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authenticate {
    private String username;
    private String password;
}
