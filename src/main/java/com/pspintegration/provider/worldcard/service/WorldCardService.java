package com.pspintegration.provider.worldcard.service;

import com.pspintegration.provider.worldcard.converter.CallbackDTOConverter;
import com.pspintegration.provider.worldcard.dto.BillingAddress;
import com.pspintegration.provider.worldcard.dto.Customer;
import com.pspintegration.provider.worldcard.dto.Order;
import com.pspintegration.web.WorldCardAuthRequest;
import com.pspintegration.web.WorldCardAuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Slf4j
@Service
public class WorldCardService {
    private static final String URL = "https://checkout.transakcia.com/api/v1/session";

    private final RestTemplate restTemplate = new RestTemplate();

    public WorldCardAuthResponse authenticate() {
        var uri = URI.create(URL);
        var worldCardRequest = buildRequest();
        var worldCardRequestResponseEntity = restTemplate.postForEntity(uri, worldCardRequest, WorldCardAuthResponse.class);

        return worldCardRequestResponseEntity.getBody();
    }

    public void handleCallback(MultiValueMap<String, String> callback) {
        var callbackDTO = CallbackDTOConverter.toDTO(callback);

        log.warn("DTO: " + callbackDTO);
    }

    private WorldCardAuthRequest buildRequest() {
        var sha1Hash = Strings.EMPTY;

        try {
            sha1Hash = generateSessionHash();
        } catch (NullPointerException | NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return new WorldCardAuthRequest(
            "6d13e2fa-539b-11ed-8193-b6d71ef108d9",
                "purchase",
                List.of("card"),
                new Order(
                        "order-1234", new BigDecimal("0.19"), "USD", "Important gift"),
                "https://example.com/cancel",
                "https://example.com/success",
                new Customer(
                        "John Doe", "test@email.com"),
                new BillingAddress(
                        "US", "CA", "Los Angeles", "Moor Building 35274", "123456", "347771112233"
                ),
                "true",
                sha1Hash
        );
    }

    private String generateSessionHash() throws NoSuchAlgorithmException {
        var dataForMd5 = """
                %s%s%s%s%s
                """
                .formatted(
                        "order-1234", "0.19", "usd", "Important gift", "2dd93d31626512c224bf50e4d4b18a2a"
                ).trim().toUpperCase();

        var md5Hash = DigestUtils.md5Hex(dataForMd5);

        return DigestUtils.sha1Hex(md5Hash);
    }
}
