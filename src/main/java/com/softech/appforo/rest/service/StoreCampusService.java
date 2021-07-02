package com.softech.appforo.rest.service;

import com.softech.appforo.rest.dao.collection.StoreCampus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface StoreCampusService extends CRUDService<StoreCampus, UUID> {
    public Flux<StoreCampus> findAllByMallCampusId(UUID id);
    public Mono<StoreCampus> updateCapacityByStoreId(UUID id, Integer record);
}
