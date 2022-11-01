package com.pspintegration.web.controller;

import com.pspintegration.provider.worldcard.service.WorldCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/world_card")
public class WorldCardController {
    private final WorldCardService worldCardService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "/auth")
    public String authenticate(Model model) {
        var redirectUrl = worldCardService.authenticate();

        model.addAttribute("redirect_url", redirectUrl.redirectUrl());

        return "auth";
    }
}
