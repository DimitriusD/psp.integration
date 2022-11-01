package com.pspintegration.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pspintegration.provider.worldcard.CallbackType;
import org.springframework.web.bind.annotation.ModelAttribute;

public record WorldCardCallbackRequest(
    CallbackType action,
    String result,
    String status,

//    @("order_id")
    Integer orderId
) { }
