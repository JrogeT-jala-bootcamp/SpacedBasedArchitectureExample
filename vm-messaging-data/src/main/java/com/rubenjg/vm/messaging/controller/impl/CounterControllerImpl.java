package com.rubenjg.vm.messaging.controller.impl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.rubenjg.pu.counter.controller.CounterController;
import com.rubenjg.pu.counter.dto.CounterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Counter Controller Implementation
 *
 * @author Rubén Jiménez
 */
@RestController
public class CounterControllerImpl implements CounterController {

    private static final Logger LOG = LoggerFactory.getLogger(CounterControllerImpl.class);
    private static final String COUNTER_APP_NAME = "Counter";

    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;
    private int count;

    /**
     * Creates a new Object.
     *
     * @param restTemplate Rest Template
     */
    @Autowired
    public CounterControllerImpl(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.count = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<CounterDto>> getCounters() {
        LOG.debug("GET /counters");
        ServiceInstance instance = getServiceInstance();
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/counters";
        LOG.debug(url);
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CounterDto>>() {
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> getCounters(@PathVariable("id") int counterId) {
        LOG.debug("GET /counters/{}", counterId);
        ServiceInstance instance = getServiceInstance();
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/counters/" + counterId;
        LOG.debug(url);
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<CounterDto>() {
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@RequestBody CounterDto counterDto) throws Exception {
        LOG.debug("POST /counters");
        getAllServiceInstances().forEach(serviceInstance -> {
            ServiceInstance instance = getServiceInstance();
            String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/counters";
            LOG.debug(url);
            restTemplate.postForObject(url, counterDto, CounterDto.class);
        });
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CounterDto> postCounters(@PathVariable("id") int counterId) throws Exception {
        LOG.debug("POST /counters/{}", counterId);
        getAllServiceInstances().forEach(serviceInstance -> {
            ServiceInstance instance = getServiceInstance();
            String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/counters/" + counterId;
            LOG.debug(url);
            restTemplate.postForObject(url, null, CounterDto.class);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<ServiceInstance> getAllServiceInstances() {
        return this.discoveryClient.getInstances(COUNTER_APP_NAME);
    }

    private ServiceInstance getServiceInstance() {
        List<ServiceInstance> instances = getAllServiceInstances();
        return instances.get(count++ % instances.size());
    }
}
