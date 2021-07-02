package com.softech.appforo.rest.dao.repository;


import com.softech.appforo.rest.dao.collection.IOTDevice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IOTDeviceRepository extends ReactiveMongoRepository<IOTDevice, UUID> {
}
