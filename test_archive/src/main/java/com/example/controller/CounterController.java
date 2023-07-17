package com.example.controller;

import com.example.model.Counter;
import com.example.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterController(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @GetMapping("/counter")
    public int getCounterValue() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        return counter.getValue();
    }

    @PostMapping("/counter")
    public void incrementCounterValue(@RequestBody int value) {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.setValue(counter.getValue() + value);
        counterRepository.save(counter);
    }
}
