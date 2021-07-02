package com.softech.appforo.rest.dao.repository;


import com.softech.appforo.rest.dao.collection.Store;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<Store, UUID> {
}
