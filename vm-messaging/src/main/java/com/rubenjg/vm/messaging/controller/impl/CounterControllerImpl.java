package com.rubenjg.vm.messaging.controller.impl;

import com.rubenjg.pu.counter.controller.CounterController;
import com.rubenjg.pu.counter.dto.CounterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Counter Controller Implementation
 *
 * @author Rubén Jiménez
 */
@RestController
public class CounterControllerImpl implements CounterController {

    private static final Logger log = LoggerFactory.getLogger(CounterControllerImpl.class);

    private RestTemplate restTemplate;

    /**
     * Creates a new Object.
     *
     * @param restTemplate Rest Template
     */
    @Autowired
    public CounterControllerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<CounterDto>> getCounters() {
        log.debug("GET /counters");
        // TODO Add logic
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> getCounters(@PathVariable("id") int counterId) {
        log.debug("GET /counters/{}", counterId);
        // TODO Add logic
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@RequestBody CounterDto counterDto) throws Exception {
        log.debug("POST /counters");
        // TODO Add logic
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@PathVariable("id") int counterId) throws Exception {
        log.debug("POST /counters/{}", counterId);
        // TODO Add logic
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
