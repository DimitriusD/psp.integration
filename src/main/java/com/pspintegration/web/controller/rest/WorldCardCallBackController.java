package com.pspintegration.web.controller.rest;

import com.pspintegration.provider.worldcard.service.WorldCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/world_card")
public class WorldCardCallBackController {
    private final WorldCardService worldCardService;

    @PostMapping(
            value = "/callback",
            consumes = {
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> callBack(@RequestBody MultiValueMap<String, String> callback) {
//        worldCardService.handleCallback(callback);

        callback.forEach((key, value) ->
                log.info(key + " : " + value));

        return ResponseEntity.ok("GhjjhGGG");
    }
}

/*
{
	action=SALE
	result=REDIRECT
	status=3DS
	order_id=1001
	trans_id=aaaff66a-904f-11ea-833e0242ac1f0007
	hash=e36d1001a7ccbfd7870de5c1eab5f86e
	trans_date=2022-10-26+11:53:40
	amount=10.00
	currency=USD
	redirect_url=https://checkout.domain.com/collector/aaaff66a-904f-11ea-833e-0242ac1f0007
redirect_params[body]=V1pggfhtGOVdfggfhfvfjyjuyjytytuhzSXoxYUlYdXlwbWtQNjNHQXJMamZDUzF5WTlDVUVsUjN2MFhMbUZIdlNSN0N1eFpRS09GOXhkhtryr5765raTFsZWJQhgfgfhgfffrtr76qH5XH+S+fpPK5tgC75hDTw=
	redirect_method=POST
	card=411111****1111
	card_expiration_date=01/2025
}
* */
