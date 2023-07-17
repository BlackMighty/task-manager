package com.example.repository;

import com.example.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface CounterRepository extends JpaRepository<Counter, Long> {
}
