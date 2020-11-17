package com.example.demo.services;

import com.example.demo.dtos.DemoRequest;
import com.example.demo.dtos.DemoResponse;
import com.example.demo.entities.DemoEntity;
import com.example.demo.repositories.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Autowired
    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public List<DemoResponse> getAll() {
        return StreamSupport.stream(demoRepository.findAll().spliterator(), false).
                map(demoEntity -> new DemoResponse(demoEntity.getId(), demoEntity.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void addDemo(DemoRequest demoRequest) {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(demoRequest.getName());

        demoRepository.save(demoEntity);
    }
}
