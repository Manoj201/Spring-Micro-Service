package com.cal.sca.service.command;

import com.cal.sca.entity.Cart;
import com.cal.sca.model.service.CreateCartRequest;
import com.cal.sca.service.Command;

public interface CreateCartCommand extends Command<Cart, CreateCartRequest> {
}
