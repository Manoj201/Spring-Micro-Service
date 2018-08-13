package com.cal.sca.controller;

import com.cal.sca.entity.Cart;
import com.cal.sca.model.controller.CreateCartModel;
import com.cal.sca.model.controller.ResponseModel;
import com.cal.sca.model.service.CreateCartRequest;
import com.cal.sca.service.ServiceExecutor;
import com.cal.sca.service.command.CreateCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @RequestMapping(value = "create" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Cart>> createCart(@RequestBody CreateCartModel requestBody) {

        CreateCartRequest request = CreateCartRequest.builder()
                .id(requestBody.getId())
                .build();

        return serviceExecutor.execute(CreateCartCommand.class, request)
                .map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());

    }

}
