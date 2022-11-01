package com.pspintegration.provider.worldcard;

import lombok.Getter;

public enum CallbackType {
    SALE("SALE"),
    THREE_DS("3DS"),
    REDIRECT("REDIRECT"),
    REFUND("REFUND"),
    RECURRING("RECURRING"),
    CHARGEBACK("CHARGEBACK");

    @Getter
    private final String typeValue;

    CallbackType(String typeValue) {
        this.typeValue = typeValue;
    }
}
