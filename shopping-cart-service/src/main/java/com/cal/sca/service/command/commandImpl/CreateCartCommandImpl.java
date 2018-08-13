package com.cal.sca.service.command.commandImpl;

import com.cal.sca.entity.Cart;
import com.cal.sca.model.service.CreateCartRequest;
import com.cal.sca.repository.CartRepository;
import com.cal.sca.service.AbstractCommand;
import com.cal.sca.service.command.CreateCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateCartCommandImpl extends AbstractCommand<Cart, CreateCartRequest> implements CreateCartCommand {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(CreateCartRequest createCartRequest) {
        Cart newCart = createCart(createCartRequest);
        return cartRepository.save(newCart);
    }

    @Override
    public Mono<List<Cart>> doExecuteList(CreateCartRequest createCartRequest) {
        return null;
    }

    private Cart createCart (CreateCartRequest request) {
        return Cart.builder()
                .id(request.getId())
                .build();
    }
}
