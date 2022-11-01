package com.pspintegration.provider.worldcard.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record BillingAddress(
        String country,

        @Size(min = 2, max = 32)
        @Pattern(regexp = "[a-zA-Z]")
        String state,

        @Size(min = 2, max = 32)
        @Pattern(regexp = "[a-zA-Z]")
        String city,

        @Size(min = 2, max = 32)
        @Pattern(regexp = "[a-zA-Z0-9]")
        String address,

        @Size(min = 2, max = 10)
        @Pattern(regexp = "[a-zA-Z0-9]")
        String zip,

        @Max(32)
        @Pattern(regexp = "[0-9+()-]")
        String phone
) { }
