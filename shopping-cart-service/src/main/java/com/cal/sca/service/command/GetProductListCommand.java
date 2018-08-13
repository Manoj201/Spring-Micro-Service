package com.cal.sca.service.command;

import com.cal.sca.entity.Product;
import com.cal.sca.model.service.GetProductListRequest;
import com.cal.sca.service.Command;



public interface GetProductListCommand extends Command<Product, GetProductListRequest> {
}
