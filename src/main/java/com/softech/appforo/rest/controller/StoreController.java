package com.softech.appforo.rest.controller;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.dao.collection.Store;
import com.softech.appforo.rest.service.MallService;
import com.softech.appforo.rest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public Mono<Store> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return storeService.findById(id);
    }

    @GetMapping
    public Flux<Store> findAll(){
        return storeService.findAll();
    }

    @PostMapping
    public Mono<Store> create(@RequestBody Store entity){
        return storeService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<Store> deleteById(@PathVariable("id") UUID id){
        return storeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<Store> update(@PathVariable("id") UUID id, @RequestBody Store entity){
        return storeService.update(id,entity);
    }

}
