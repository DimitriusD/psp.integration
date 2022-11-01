package com.pspintegration.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WorldCardAuthResponse(
        @JsonProperty("redirect_url") String redirectUrl
) { }
