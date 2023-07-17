package com.example.Service;

import com.example.model.Counter;
import com.example.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {
    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Transactional
    public int getCounterValue() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        return counter.getValue();
    }

    @Transactional
    public void incrementCounterValue(int value) {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.setValue(counter.getValue() + value);
        counterRepository.save(counter);
    }
}
