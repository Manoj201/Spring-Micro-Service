package com.cal.sca.service.command;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.GetProductRequest;
import com.cal.sca.service.Command;

public interface GetProductCommand extends Command<Product, GetProductRequest> {

}
