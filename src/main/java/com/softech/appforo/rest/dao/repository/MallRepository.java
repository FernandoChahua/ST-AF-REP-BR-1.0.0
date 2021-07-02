package com.softech.appforo.rest.dao.repository;


import com.softech.appforo.rest.dao.collection.Mall;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MallRepository extends ReactiveMongoRepository<Mall, UUID> {
}
