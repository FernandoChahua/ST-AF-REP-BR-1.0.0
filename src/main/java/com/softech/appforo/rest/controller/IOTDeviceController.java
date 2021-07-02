package com.softech.appforo.rest.controller;

import com.softech.appforo.rest.dao.collection.IOTDevice;
import com.softech.appforo.rest.dao.collection.MallCampus;
import com.softech.appforo.rest.service.IOTDeviceService;
import com.softech.appforo.rest.service.MallCampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/iot-device")
public class IOTDeviceController {
    @Autowired
    private IOTDeviceService iotDeviceService;

    @GetMapping("/{id}")
    public Mono<IOTDevice> findById(@PathVariable("id") UUID id){
        System.out.println(id);
        return iotDeviceService.findById(id);
    }

    @GetMapping
    public Flux<IOTDevice> findAll(){
        return iotDeviceService.findAll();
    }

    @PostMapping
    public Mono<IOTDevice> create(@RequestBody IOTDevice entity){
        return iotDeviceService.create(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<IOTDevice> deleteById(@PathVariable("id") UUID id){
        return iotDeviceService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<IOTDevice> update(@PathVariable("id") UUID id, @RequestBody IOTDevice entity){
        return iotDeviceService.update(id,entity);
    }

}
