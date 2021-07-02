package com.softech.appforo.rest.service.impl;

import com.softech.appforo.rest.dao.collection.Store;
import com.softech.appforo.rest.dao.repository.StoreRepository;
import com.softech.appforo.rest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Mono<Store> findById(UUID uuid) {
        return storeRepository.findById(uuid);
    }

    @Override
    public Flux<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Mono<Store> update(UUID uuid, Store entity) {
        return null;
    }

    @Override
    public Mono<Store> create(Store entity) {
        return Mono.just(entity)
                .map(e -> {
                    e.setStoreId(UUID.randomUUID());
                    return e;
                })
                .flatMap(e -> storeRepository.save(e));
    }

    @Override
    public Mono<Store> deleteById(UUID uuid) {
        return null;
    }
}
