package com.softech.appforo.rest.service.impl;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.dao.collection.MallCampus;
import com.softech.appforo.rest.dao.repository.MallCampusRepository;
import com.softech.appforo.rest.service.MallCampusService;
import com.softech.appforo.rest.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MallCampusImpl implements MallCampusService {
    @Autowired
    private MallCampusRepository mallCampusRepository;

    @Autowired
    private MallService mallService;

    @Override
    public Mono<MallCampus> findById(UUID uuid) {
        return mallCampusRepository.findById(uuid);
    }

    @Override
    public Flux<MallCampus> findAll() {
        return mallCampusRepository.findAll();
    }

    @Override
    public Mono<MallCampus> update(UUID uuid, MallCampus entity) {
        return null;
    }

    @Override
    public Mono<MallCampus> create(MallCampus entity) {

        Mono<Mall> mall = mallService.findById(entity.getMall().getMallId());



        return mall.map(e -> {
            entity.setMall(e);
            return entity;
        })
                .map(e -> {
                    e.setMallCampusId(UUID.randomUUID());
                    return e;
                })
                .flatMap(e -> mallCampusRepository.save(e));
    }

    @Override
    public Mono<MallCampus> deleteById(UUID uuid) {
        return null;
    }

    @Override
    public Flux<MallCampus> findAllByMallId(UUID id) {
        return mallCampusRepository.findAllByMallMallId(id);
    }
}
