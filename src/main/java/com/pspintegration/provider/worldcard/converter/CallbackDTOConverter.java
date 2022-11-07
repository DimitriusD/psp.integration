package com.pspintegration.provider.worldcard.converter;

import com.pspintegration.provider.worldcard.CallbackStatus;
import com.pspintegration.provider.worldcard.CallbackType;
import com.pspintegration.provider.worldcard.dto.CallbackDTO;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class CallbackDTOConverter {

    public static final String DEFAULT_VALUE_FOR_STRING = "NULL";

    public static CallbackDTO toDTO(final MultiValueMap<String, String> callback) {
        var callbackDTO = buildCallbackDTO(callback);
        var status = callback.get("status").get(0);

        return "success".equals(status)
                ? addSuccessDataToDTO(callbackDTO, callback)
                : addFailDataToDTO(callbackDTO, callback);
    }

    private static CallbackDTO buildCallbackDTO(final MultiValueMap<String, String> callback) {
        var callbackDTO = new CallbackDTO();
        callbackDTO.setId(UUID.fromString(callback.get("id").get(0)));
        callbackDTO.setOrderNumber(callback.get("order_number").get(0));
        callbackDTO.setOrderAmount(new BigDecimal(callback.get("order_amount").get(0)));
        callbackDTO.setOrderCurrency(callback.get("order_currency").get(0));
        callbackDTO.setOrderDescription(callback.get("order_description").get(0));
        callbackDTO.setCallbackType(CallbackType.valueOf(callback.get("type").get(0).toUpperCase()));
        callbackDTO.setCallbackStatus(CallbackStatus.valueOf(callback.get("status").get(0).toUpperCase()));
        callbackDTO.setCardNumber(
                Objects.isNull(callback.get("card"))
                        ? DEFAULT_VALUE_FOR_STRING
                        : callback.get("card").get(0));
        callbackDTO.setCardExpDate(
                Objects.isNull(callback.get("card_expiration_date"))
                        ? DEFAULT_VALUE_FOR_STRING
                        : callback.get("card_expiration_date").get(0));
        callbackDTO.setDateTime(parseDateTime(callback));
        callbackDTO.setHash(callback.get("hash").get(0));

        return callbackDTO;
    }

    private static CallbackDTO addSuccessDataToDTO(final CallbackDTO callbackDTO,
                                                   final MultiValueMap<String, String> callback) {
        callbackDTO.setScheduleId(Objects.isNull(callback.get("schedule_id"))
                ? null
                : UUID.fromString(callback.get("schedule_id").get(0)));
//        callbackDTO.setRecurringInitTransId(UUID.fromString(callback.get("recurring_init_trans_id").get(0)));
//        callbackDTO.setRecurringToken(UUID.fromString(callback.get("recurring_token").get(0)));

        return callbackDTO;
    }

    private static CallbackDTO addFailDataToDTO(final CallbackDTO callbackDTO,
                                                final MultiValueMap<String, String> callback) {
        callbackDTO.setReason(callback.get("reason").get(0));

        return callbackDTO;
    }

    private static LocalDateTime parseDateTime(MultiValueMap<String, String> callback) {
        return LocalDateTime.parse(
                callback.get("date").get(0),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
