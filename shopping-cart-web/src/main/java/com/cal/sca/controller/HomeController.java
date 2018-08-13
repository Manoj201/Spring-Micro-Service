package com.cal.sca.controller;

import com.cal.sca.model.controller.ResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Victor Fonseca
 * @since 01/08/18
 */
@RestController
public class HomeController {

    @Value("${spring.application.name}")
    private String applicationName;


    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<String>> home() {
        return Mono.just(ResponseModel.ok(applicationName))
                .subscribeOn(Schedulers.elastic());
    }


}
