package com.example.demo.controllers;

import com.example.demo.dtos.DemoRequest;
import com.example.demo.dtos.DemoResponse;
import com.example.demo.repositories.DemoRepository;
import com.example.demo.services.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private final DemoService demoService;
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/api/demo")
    public ResponseEntity<List<DemoResponse>> getAll() {
        return new ResponseEntity<>(demoService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/demo")
    public ResponseEntity addDemo(@RequestBody DemoRequest demoRequest) {
        demoService.addDemo(demoRequest);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
