package com.pspintegration.provider.worldcard;

import com.pspintegration.provider.worldcard.dto.BillingAddress;
import com.pspintegration.provider.worldcard.dto.Customer;
import com.pspintegration.provider.worldcard.dto.Order;

import java.util.List;

public record WorldCardRequest(String merchant_key, String operation, List<String> methods, Order order, String cancel_url,
                        String success_url, Customer customer, BillingAddress billing_address, String recurring_init,
                        String hash) { }
