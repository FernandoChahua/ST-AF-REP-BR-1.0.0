package com.softech.appforo.rest.service.impl;

import com.softech.appforo.rest.dao.collection.IOTDevice;
import com.softech.appforo.rest.dao.collection.StoreCampus;
import com.softech.appforo.rest.dao.repository.IOTDeviceRepository;
import com.softech.appforo.rest.service.IOTDeviceService;
import com.softech.appforo.rest.service.StoreCampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class IOTDeviceServiceImpl implements IOTDeviceService {
    @Autowired
    private IOTDeviceRepository iotDeviceRepository;

    @Autowired
    private StoreCampusService storeCampusService;

    @Override
    public Mono<IOTDevice> findById(UUID uuid) {
        return iotDeviceRepository.findById(uuid);
    }

    @Override
    public Flux<IOTDevice> findAll() {
        return iotDeviceRepository.findAll();
    }

    @Override
    public Mono<IOTDevice> update(UUID uuid, IOTDevice entity) {
        return null;
    }

    @Override
    public Mono<IOTDevice> create(IOTDevice entity) {
        Mono<StoreCampus> storeCampusMono = storeCampusService.findById(entity.getStoreCampus().getStoreCampusId());

        return storeCampusMono.map( e -> {
            entity.setStoreCampus(e);
            entity.setIotDeviceId(UUID.randomUUID());
            return entity;
        }).flatMap(
                e -> iotDeviceRepository.save(e)
        );
    }

    @Override
    public Mono<IOTDevice> deleteById(UUID uuid) {
        return null;
    }
}
