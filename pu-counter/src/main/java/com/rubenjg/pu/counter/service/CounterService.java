package com.rubenjg.pu.counter.service;

import com.rubenjg.pu.counter.dto.CounterDto;

import java.util.List;

/**
 * Counter Service
 *
 * @author Rubén Jiménez
 */
public interface CounterService {

    /**
     * Retrieves all Counters
     *
     * @return A list of counters
     * @throws Exception If one occurs
     */
    List<CounterDto> getAll() throws Exception;

    /**
     * Retrieves a Counter by its Id.
     *
     * @param id Counter Id
     * @return A Counter
     * @throws Exception If one occurs
     */
    CounterDto getById(long id) throws Exception;

    /**
     * Creates a new Counter
     *
     * @param counterDto Initial Counter state
     * @return Created Counter
     * @throws Exception If one occurs
     */
    CounterDto createCounter(CounterDto counterDto) throws Exception;

    /**
     * Increases a Counter
     *
     * @param id Counter Id
     * @return Updated Counter
     * @throws Exception If one occurs
     */
    CounterDto increaseCounter(long id) throws Exception;
}