package com.geofit.geofit.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geofit.geofit.chatbot.dto.request.BizRequest;
import com.geofit.geofit.chatbot.dto.response.BizResponse;
import com.geofit.geofit.chatbot.service.ExternalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external")
public class ExternalServiceController {

    private final ExternalService externalService;

    @PostMapping("/biz")
    public ResponseEntity<BizResponse> callBiz(
        @RequestBody BizRequest request
    ) {
        BizResponse response = externalService.callBiz(request);
        return ResponseEntity.ok(response);
    }
}
