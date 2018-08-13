package com.cal.sca.service;

import reactor.core.publisher.Mono;

import java.util.List;

public interface Command<RESULT, REQUEST> {

    Mono<RESULT> execute(REQUEST request);

    Mono<List<RESULT>> executeList(REQUEST request);
}
