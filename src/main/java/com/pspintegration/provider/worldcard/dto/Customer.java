package com.pspintegration.provider.worldcard.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record Customer(

        @Size(min = 2, max = 32)
        @Pattern(regexp = "[a-zA-Z]")
        String name,

        @Email(regexp = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$")
        String email
) { }
