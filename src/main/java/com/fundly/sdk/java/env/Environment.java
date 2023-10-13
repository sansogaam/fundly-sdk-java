package com.fundly.sdk.java.env;

public enum Environment {
    SANDBOX("SANDBOX"),
    PRODUCTION("PRODUCTION");

    private String value;
    Environment(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
