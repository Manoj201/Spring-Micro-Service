package com.cal.sca.service.command.commandImpl;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.GetProductListRequest;
import com.cal.sca.repository.ProductRepository;
import com.cal.sca.service.AbstractCommand;
import com.cal.sca.service.command.GetProductListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GetProductListCommandImpl extends AbstractCommand<Product, GetProductListRequest> implements GetProductListCommand {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(GetProductListRequest request) {
        return null;
    }

    @Override
    public Mono<List<Product>> doExecuteList(GetProductListRequest request) {
        Mono<List<Product>> productList =  productRepository.findAll().take(10).skip(request.getSkip()).collectList();
        return productList;
    }
}
