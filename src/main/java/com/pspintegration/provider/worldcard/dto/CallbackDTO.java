package com.pspintegration.provider.worldcard.dto;

import com.pspintegration.provider.worldcard.CallbackStatus;
import com.pspintegration.provider.worldcard.CallbackType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
public class CallbackDTO {
    private UUID id;
    private String hash;
    private String reason;

    @Nullable
    private UUID scheduleId;
    private String cardNumber;
    private String orderNumber;
    private String cardExpDate;
    private UUID recurringToken;
    private String orderCurrency;
    private BigDecimal orderAmount;
    private LocalDateTime dateTime;
    private String orderDescription;
    private CallbackType callbackType;
    private UUID recurringInitTransId;
    private CallbackStatus callbackStatus;
}
