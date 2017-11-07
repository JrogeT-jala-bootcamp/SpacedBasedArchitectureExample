package com.rubenjg.pu.counter.service.impl;

import com.rubenjg.pu.counter.dto.CounterDto;
import com.rubenjg.pu.counter.entity.Counter;
import com.rubenjg.pu.counter.repository.CounterRepository;
import com.rubenjg.pu.counter.service.CounterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Counter Service implementation
 *
 * @author Rubén Jiménez
 */
@Service
public class CounterServiceImpl implements CounterService {

    private CounterRepository counterRepository;
    private ModelMapper modelMapper;

    /**
     * Creates a new Object.
     *
     * @param counterRepository Counter Repository
     * @param modelMapper       Model Mapper
     */
    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository, ModelMapper modelMapper) {
        this.counterRepository = counterRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CounterDto> getAll() throws Exception {
        return this.counterRepository.findAll()
                .stream()
                .map(counter -> modelMapper.map(counter, CounterDto.class))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CounterDto getById(long id) throws Exception {
        return this.modelMapper.map(this.counterRepository.getOne(id), CounterDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CounterDto createCounter(CounterDto counterDto) throws Exception {
        Counter counter = this.counterRepository.saveAndFlush(new Counter(
                counterDto.getName(),
                counterDto.getCount()));
        return this.modelMapper.map(counter, CounterDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CounterDto increaseCounter(long id) throws Exception {
        Counter counter = this.counterRepository.getOne(id);
        counter.setCount(counter.getCount() + 1);
        counter = this.counterRepository.saveAndFlush(counter);
        return this.modelMapper.map(counter, CounterDto.class);
    }
}
