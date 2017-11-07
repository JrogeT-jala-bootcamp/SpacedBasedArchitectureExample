package com.rubenjg.pu.counter.controller.impl;

import com.rubenjg.pu.counter.controller.CounterController;
import com.rubenjg.pu.counter.dto.CounterDto;
import com.rubenjg.pu.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Counter Controller Implementation
 *
 * @author Rubén Jiménez
 */
@RestController
public class CounterControllerImpl implements CounterController {

    private CounterService counterService;

    @Autowired
    public CounterControllerImpl(CounterService counterService) {
        this.counterService = counterService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<CounterDto>> getCounters() throws Exception {
        return new ResponseEntity<>(this.counterService.getAll(), HttpStatus.OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> getCounters(@PathVariable("id") int counterId) throws Exception {
        return new ResponseEntity<>(this.counterService.getById(counterId), HttpStatus.OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@RequestBody CounterDto counterDto) throws Exception {
        return new ResponseEntity<>(this.counterService.createCounter(counterDto), HttpStatus.CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@PathVariable("id") int counterId) throws Exception {
        return new ResponseEntity<>(this.counterService.increaseCounter(counterId), HttpStatus.OK);
    }
}
