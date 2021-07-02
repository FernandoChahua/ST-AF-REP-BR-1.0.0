package com.softech.appforo.rest.controller;


import com.softech.appforo.rest.dao.collection.MallCampus;
import com.softech.appforo.rest.dao.collection.StoreCampus;
import com.softech.appforo.rest.service.MallCampusService;
import com.softech.appforo.rest.service.StoreCampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/store-campus")
public class StoreCampusController {
    @Autowired
    private StoreCampusService storeCampusService;

    @GetMapping("/{id}")
    public Mono<StoreCampus> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return storeCampusService.findById(id);
    }

    @GetMapping
    public Flux<StoreCampus> findAll(){
        return storeCampusService.findAll();
    }

    @PostMapping
    public Mono<StoreCampus> create(@RequestBody StoreCampus entity){
        return storeCampusService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<StoreCampus> deleteById(@PathVariable("id") UUID id){
        return storeCampusService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<StoreCampus> update(@PathVariable("id") UUID id, @RequestBody StoreCampus entity){
        return storeCampusService.update(id,entity);
    }

    @GetMapping("/mall-campus/{id}")
    public Flux<StoreCampus> findAllByMallCampusId(@PathVariable("id") UUID id){ return storeCampusService.findAllByMallCampusId(id); }
}
