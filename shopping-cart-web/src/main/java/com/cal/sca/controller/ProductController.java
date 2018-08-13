package com.cal.sca.controller;

import com.cal.sca.entity.Product;
import com.cal.sca.model.controller.AddProductModel;
import com.cal.sca.model.controller.ResponseModel;
import com.cal.sca.model.service.CreateProductRequest;
import com.cal.sca.model.service.GetProductListRequest;
import com.cal.sca.model.service.GetProductRequest;
import com.cal.sca.service.ServiceExecutor;
import com.cal.sca.service.command.CreateProductCommand;
import com.cal.sca.service.command.GetProductCommand;
import com.cal.sca.service.command.GetProductListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Product>> createProduct(@RequestBody AddProductModel requestBody) {
        CreateProductRequest request = CreateProductRequest.builder()
                .id(requestBody.getId())
                .name(requestBody.getName())
                .price(requestBody.getPrice())
                .stock(requestBody.getStock())
                .build();

        return serviceExecutor.execute(CreateProductCommand.class, request)
                .map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Product>> getProduct(@PathVariable("productId") String id) {
        GetProductRequest request = GetProductRequest.builder()
                .id(id)
                .build();


        return serviceExecutor.execute(GetProductCommand.class, request)
                .map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<List<Product>>> getProductList() {

        GetProductListRequest request = GetProductListRequest.builder()
                .skip(0)
                .build();
        return serviceExecutor.executeList(GetProductListCommand.class, request)
                .map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
