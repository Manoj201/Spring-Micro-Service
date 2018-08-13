package com.cal.sca.service;

import reactor.core.publisher.Mono;

import java.util.List;

public interface ServiceExecutor {

    <T, R> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request);

    <T, R> Mono<List<T>> executeList(Class<? extends Command<T, R>> commandClass, R request);
}
