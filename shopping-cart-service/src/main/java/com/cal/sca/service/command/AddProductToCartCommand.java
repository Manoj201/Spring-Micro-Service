package com.cal.sca.service.command;

import com.cal.sca.entity.Cart;
import com.cal.sca.model.service.AddProductToCartRequest;
import com.cal.sca.service.Command;

public interface AddProductToCartCommand extends Command<Cart, AddProductToCartRequest> {
}
