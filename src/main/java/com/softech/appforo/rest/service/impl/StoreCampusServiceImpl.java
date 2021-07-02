package com.softech.appforo.rest.service.impl;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.dao.collection.MallCampus;
import com.softech.appforo.rest.dao.collection.Store;
import com.softech.appforo.rest.dao.collection.StoreCampus;
import com.softech.appforo.rest.dao.repository.StoreCampusRepository;
import com.softech.appforo.rest.service.MallCampusService;
import com.softech.appforo.rest.service.StoreCampusService;
import com.softech.appforo.rest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class StoreCampusServiceImpl implements StoreCampusService {

    @Autowired
    private StoreCampusRepository storeCampusRepository;

    @Autowired
    private StoreService storeService;

    @Autowired
    private MallCampusService mallCampusService;


    @Override
    public Flux<StoreCampus> findAllByMallCampusId(UUID id) {
        return storeCampusRepository.findAllByMallCampusMallCampusId(id);
    }

    @Override
    public Mono<StoreCampus> updateCapacityByStoreId(UUID id, Integer record) {
        return storeCampusRepository.findById(id)
                .map( e -> {
                    e.setCurrentCapacity(e.getCurrentCapacity() + record);
                    return e;
                }).flatMap( e -> storeCampusRepository.save(e));
    }

    @Override
    public Mono<StoreCampus> findById(UUID uuid) {
        return storeCampusRepository.findById(uuid);
    }

    @Override
    public Flux<StoreCampus> findAll() {
        return storeCampusRepository.findAll();
    }

    @Override
    public Mono<StoreCampus> update(UUID uuid, StoreCampus entity) {
        return null;
    }

    @Override
    public Mono<StoreCampus> create(StoreCampus entity) {
        Mono<MallCampus> mallCampusMono = mallCampusService.findById(entity.getMallCampus().getMallCampusId());
        Mono<Store> storeMono = storeService.findById(entity.getStore().getStoreId());

        return Mono.zip(mallCampusMono, storeMono).flatMap(data -> {
            entity.setStore(data.getT2());
            entity.setMallCampus(data.getT1());
            entity.setStoreCampusId(UUID.randomUUID());
            return storeCampusRepository.save(entity);
        });
    }

    @Override
    public Mono<StoreCampus> deleteById(UUID uuid) {
        return null;
    }
}
