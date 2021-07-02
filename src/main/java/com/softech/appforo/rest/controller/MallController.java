package com.softech.appforo.rest.controller;

import com.softech.appforo.rest.dao.collection.Mall;
import com.softech.appforo.rest.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/mall")
public class MallController {
    @Autowired
    private MallService mallService;

    @GetMapping("/{id}")
    public Mono<Mall> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return mallService.findById(id);
    }

    @GetMapping
    public Flux<Mall> findAll(){
        return mallService.findAll();
    }

    @PostMapping
    public Mono<Mall> create(@RequestBody Mall entity){
        return mallService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<Mall> deleteById(@PathVariable("id") UUID id){
        return mallService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<Mall> update(@PathVariable("id") UUID id, @RequestBody Mall entity){
        return mallService.update(id,entity);
    }

}
