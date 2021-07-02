package com.softech.appforo.rest.service;

import com.softech.appforo.rest.dao.collection.MallCampus;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface MallCampusService extends CRUDService<MallCampus, UUID>{
    Flux<MallCampus> findAllByMallId(UUID id);
}
