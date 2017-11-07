package com.rubenjg.pu.counter.controller;

import com.rubenjg.pu.counter.dto.CounterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Counter Controller
 *
 * @author Rubén Jiménez
 */
public interface CounterController {

    /**
     * Returns all Counters
     *
     * @return All Counters
     */
    @GetMapping(value = "counters", produces = "application/json")
    ResponseEntity<List<CounterDto>> getCounters() throws Exception;

    /**
     * Returns a Counter
     *
     * @param counterId Counter Id
     * @return Counter
     */
    @GetMapping(value = "counters/{id}", produces = "application/json")
    ResponseEntity<CounterDto> getCounters(@PathVariable("id") int counterId) throws Exception;

    /**
     * Creates a new Counter
     *
     * @param counterDto Counter
     * @return Created Counter
     */
    @PostMapping(value = "counters", consumes = "application/json", produces = "application/json")
    ResponseEntity<CounterDto> postCounters(@RequestBody CounterDto counterDto) throws Exception;


    /**
     * Increases the value of an existing Counter
     *
     * @param counterId Counter Id
     * @return Updated Counter
     */
    @PostMapping(value = "counters/{id}", produces = "application/json")
    ResponseEntity<CounterDto> postCounters(@PathVariable("id") int counterId) throws Exception;
}
