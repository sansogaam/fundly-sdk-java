package com.fundly.sdk.java.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class CreditLimit {
    private int retailerId;
    private double totalCreditLimit;
    private double availableCreditLimit;
    private double usedCreditLimit;
}
