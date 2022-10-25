package com.pspintegration.web.controller;

import com.pspintegration.provider.worldcard.WorldCardResponse;
import com.pspintegration.provider.worldcard.WorldCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/world_card")
public class WorldCardController {
    private final WorldCardService worldCardService;

    @GetMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorldCardResponse> authenticate() {
        var redirectUrl = worldCardService.authenticate();

        return ResponseEntity.ok(redirectUrl);
    }
}
