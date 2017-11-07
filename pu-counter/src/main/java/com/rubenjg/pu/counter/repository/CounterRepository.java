package com.rubenjg.pu.counter.repository;

import com.rubenjg.pu.counter.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Counter} objects
 */
@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
}
