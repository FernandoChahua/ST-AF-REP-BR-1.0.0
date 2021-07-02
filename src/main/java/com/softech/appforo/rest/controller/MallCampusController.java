package com.softech.appforo.rest.controller;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.dao.collection.MallCampus;
import com.softech.appforo.rest.service.MallCampusService;
import com.softech.appforo.rest.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/mall-campus")
public class MallCampusController {
    @Autowired
    private MallCampusService mallCampusService;

    @GetMapping("/{id}")
    public Mono<MallCampus> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return mallCampusService.findById(id);
    }

    @GetMapping
    public Flux<MallCampus> findAll(){
        return mallCampusService.findAll();
    }

    @PostMapping
    public Mono<MallCampus> create(@RequestBody MallCampus entity){
        return mallCampusService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<MallCampus> deleteById(@PathVariable("id") UUID id){
        return mallCampusService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<MallCampus> update(@PathVariable("id") UUID id, @RequestBody MallCampus entity){
        return mallCampusService.update(id,entity);
    }

    @GetMapping("/mall/{id}")
    public Flux<MallCampus> findAllByMallId(@PathVariable("id") UUID id){ return mallCampusService.findAllByMallId(id); }
}
