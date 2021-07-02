package com.softech.appforo.rest.service.impl;


import com.softech.appforo.rest.dao.collection.CapacityRecord;
import com.softech.appforo.rest.dao.repository.CapacityRecordRepository;
import com.softech.appforo.rest.service.CapacityRecordService;
import com.softech.appforo.rest.service.StoreCampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CapacityRecordServiceImpl implements CapacityRecordService {
    @Autowired
    private CapacityRecordRepository capacityRecordRepository;
    @Autowired
    private StoreCampusService storeCampusService;

    @Override
    public Mono<CapacityRecord> findById(UUID uuid) {
        return capacityRecordRepository.findById(uuid);
    }

    @Override
    public Flux<CapacityRecord> findAll() {
        return capacityRecordRepository.findAll();
    }

    @Override
    public Mono<CapacityRecord> update(UUID uuid, CapacityRecord entity) {
        return null;
    }

    @Override
    public Mono<CapacityRecord> create(CapacityRecord entity) {

        return storeCampusService.updateCapacityByStoreId(entity.getStoreCampus().getStoreCampusId(),entity.getRecord())
                .map( e -> {
                    entity.setStoreCampus(e);
                    entity.setCapacityRecordId(UUID.randomUUID());
                    entity.setRegisterTime(LocalDateTime.now());

                    return entity;
                }).flatMap(e -> capacityRecordRepository.save(e));
    }

    @Override
    public Mono<CapacityRecord> deleteById(UUID uuid) {
        return null;
    }
}
