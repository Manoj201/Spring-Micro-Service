package com.cal.sca.model.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProductToCartModel {

    private String productId;

    private Integer quantity;
}
