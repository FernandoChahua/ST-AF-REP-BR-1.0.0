package com.softech.appforo.rest.service.impl;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.dao.repository.MallRepository;
import com.softech.appforo.rest.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MallServiceImpl implements MallService {

    @Autowired
    private MallRepository mallRepository;

    @Override
    public Mono<Mall> findById(UUID uuid) {
        return mallRepository.findById(uuid);
    }

    @Override
    public Flux<Mall> findAll() {
        return mallRepository.findAll();
    }

    @Override
    public Mono<Mall> update(UUID uuid, Mall entity) {
        return null;
    }

    @Override
    public Mono<Mall> create(Mall entity) {
        return Mono.just(entity)
                .map(e -> {
                    e.setMallId(UUID.randomUUID());
                    return e;
                })
                .flatMap(e -> mallRepository.save(e));
    }

    @Override
    public Mono<Mall> deleteById(UUID uuid) {
        return null;
    }
}
