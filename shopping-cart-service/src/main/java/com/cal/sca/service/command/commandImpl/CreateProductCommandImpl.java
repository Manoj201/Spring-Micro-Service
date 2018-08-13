package com.cal.sca.service.command.commandImpl;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.CreateProductRequest;
import com.cal.sca.repository.ProductRepository;
import com.cal.sca.service.AbstractCommand;
import com.cal.sca.service.command.CreateProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateProductCommandImpl extends AbstractCommand<Product, CreateProductRequest> implements CreateProductCommand {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(CreateProductRequest request) {
        Product newProduct = createProduct(request);
        return productRepository.save(newProduct);
    }

    @Override
    public Mono<List<Product>> doExecuteList(CreateProductRequest request) {
        return null;
    }

    private Product createProduct(CreateProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }
}
