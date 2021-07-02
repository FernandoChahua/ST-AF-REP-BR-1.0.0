package com.softech.appforo.rest.controller;


import com.softech.appforo.rest.dao.collection.CapacityRecord;
import com.softech.appforo.rest.dao.collection.IOTDevice;
import com.softech.appforo.rest.service.CapacityRecordService;
import com.softech.appforo.rest.service.IOTDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/capacity-record")
public class CapacityRecordController {
    @Autowired
    private CapacityRecordService capacityRecordService;

    @GetMapping("/{id}")
    public Mono<CapacityRecord> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return capacityRecordService.findById(id);
    }

    @GetMapping
    public Flux<CapacityRecord> findAll(){
        return capacityRecordService.findAll();
    }

    @PostMapping
    public Mono<CapacityRecord> create(@RequestBody CapacityRecord entity){
        return capacityRecordService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<CapacityRecord> deleteById(@PathVariable("id") UUID id){
        return capacityRecordService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<CapacityRecord> update(@PathVariable("id") UUID id, @RequestBody CapacityRecord entity){
        return capacityRecordService.update(id,entity);
    }

}