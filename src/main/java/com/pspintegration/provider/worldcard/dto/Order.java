package com.pspintegration.provider.worldcard.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public record Order(

        @NotEmpty
        @Max(255)
        @Pattern(regexp = "[a-zA-Z0-9-]")
        String number,

        @NotEmpty
        @Max(255)
        @Pattern(regexp = "[0-9]")
        BigDecimal amount,

        @Max(3)
        @NotEmpty
        @Pattern(regexp = "[A-Z]")
        String currency,

        @Size(min = 2, max = 1024)
        @Pattern(regexp = "[a-zA-Z0-9!\"#$%&'()*+,./:;&@]")
        String description
) { }
