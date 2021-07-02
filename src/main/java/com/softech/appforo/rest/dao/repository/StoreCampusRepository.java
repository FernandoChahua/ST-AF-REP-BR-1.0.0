package com.softech.appforo.rest.dao.repository;

import com.softech.appforo.rest.dao.collection.StoreCampus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface StoreCampusRepository extends ReactiveMongoRepository<StoreCampus, UUID> {
    Flux<StoreCampus> findAllByMallCampusMallCampusId(UUID id);
}
