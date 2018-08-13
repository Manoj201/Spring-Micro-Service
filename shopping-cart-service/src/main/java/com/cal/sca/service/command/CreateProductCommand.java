package com.cal.sca.service.command;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.CreateProductRequest;
import com.cal.sca.service.Command;

public interface CreateProductCommand extends Command<Product, CreateProductRequest> {

}
