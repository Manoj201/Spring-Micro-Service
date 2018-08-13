package com.cal.sca.service.command.commandImpl;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.GetProductRequest;
import com.cal.sca.repository.ProductRepository;
import com.cal.sca.service.AbstractCommand;
import com.cal.sca.service.command.GetProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GetProductCommandImpl extends AbstractCommand<Product, GetProductRequest> implements GetProductCommand {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(GetProductRequest request) {
        return productRepository.findById(request.getId());
    }

    @Override
    public Mono<List<Product>> doExecuteList(GetProductRequest request) {
        return null;
    }
}
