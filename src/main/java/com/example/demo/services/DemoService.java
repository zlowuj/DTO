package com.example.demo.services;

import com.example.demo.dtos.DemoResponse;
import com.example.demo.dtos.DemoRequest;

import java.util.List;

public interface DemoService {
    List<DemoResponse> getAll();

    void addDemo(DemoRequest demoRequest);
}
