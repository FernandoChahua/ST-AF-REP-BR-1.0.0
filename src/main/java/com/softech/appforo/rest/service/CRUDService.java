package com.softech.appforo.rest.service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService <T,ID>{
    Mono<T> findById(ID uuid);

    Flux<T> findAll();

    Mono<T> update(ID uuid,T entity);

    Mono<T> create(T entity);

    Mono<T> deleteById(ID uuid);
}
