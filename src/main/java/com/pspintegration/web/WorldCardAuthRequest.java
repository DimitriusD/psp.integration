package com.pspintegration.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pspintegration.provider.worldcard.dto.BillingAddress;
import com.pspintegration.provider.worldcard.dto.Customer;
import com.pspintegration.provider.worldcard.dto.Order;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.List;

public record WorldCardAuthRequest(

        @JsonProperty("merchant_key")
        String merchantKey,
        String operation,
        List<String> methods,
        Order order,

        @Max(1024)
        @JsonProperty("cancel_url")
        String cancelUrl,

        @Max(1024)
        @JsonProperty("success_url")
        String successUrl,
        Customer customer,

        @JsonProperty("billing_address")
        BillingAddress billingAddress,

        @JsonProperty("recurring_init")
        String recurringInit,
        String hash
) { }
