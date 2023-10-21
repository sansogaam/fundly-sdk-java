package com.fundly.sdk.java.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ERPRetailerKey {
    private int erpId;
    private int erpRetailerId;
    private int retailerId;
    private String erpSecurityKey;
}
