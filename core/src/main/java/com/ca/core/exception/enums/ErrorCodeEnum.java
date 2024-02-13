package com.ca.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Invalid Tax Number", "ON-0001"),
    ON0002("Unavailable Tax Number", "ON-0002"),
    ON0003("Unavailable Email", "ON-0003"),
    ON0004("Fail to create user", "ON-0004"),

    TR0001("Shopkeeper user does not have transfer function available.", "TR-0001"),
    TR0002("Insufficient funds.", "TR-0002"),
    TR0003("Transaction is invalid.", "TR-0003"),
    TR0004("Fail to transfer value", "TR-0004"),
    TR0005("Transaction not authorized", "TR-0005"),
    TR0006("Fail to create transaction", "TR-0006"),

    TRP0001("Invalid pin", "TRP-0001"),

    WA0001("Wallet not found", "WA0001"),
    NF0001("Fail to send user notification", "NF0001"),
    AUTH0001("Fail to authenticate user", "AUTH0001");

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
