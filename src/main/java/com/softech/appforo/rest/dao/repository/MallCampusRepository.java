package com.softech.appforo.rest.dao.repository;

import com.softech.appforo.rest.dao.collection.MallCampus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface MallCampusRepository extends ReactiveMongoRepository<MallCampus, UUID> {
    Flux<MallCampus> findAllByMallMallId(UUID id);
}
