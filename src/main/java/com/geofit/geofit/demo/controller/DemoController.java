package com.geofit.geofit.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geofit.geofit.chatbot.dto.response.MessageResponse;
import com.geofit.geofit.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/chatbot")
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/1")
    public ResponseEntity<MessageResponse> getOne() {
        MessageResponse response = demoService.getOne();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/2")
    public ResponseEntity<MessageResponse> getTwo() {
        MessageResponse response = demoService.getTwo();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/3")
    public ResponseEntity<MessageResponse> getThree() {
        MessageResponse response = demoService.getThree();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/4")
    public ResponseEntity<MessageResponse> getFour() {
        MessageResponse response = demoService.getFour();
        return ResponseEntity.ok(response);
    }

    // @GetMapping("/all")
    // public ResponseEntity<List<MessageResponse>> getAll() {
    //     List<MessageResponse> responses = demoService.getAllResponses();
    //     return ResponseEntity.ok(responses);
    // }
}
