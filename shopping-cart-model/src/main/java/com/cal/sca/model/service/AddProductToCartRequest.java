package com.cal.sca.model.service;

import com.cal.sca.validation.CartMustExists;
import com.cal.sca.validation.ProductMustExists;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AddProductToCartRequest {

    @NotBlank
    @CartMustExists
    private String cartId;

    @NotBlank
    @ProductMustExists
    private String productId;

    @Min(1)
    @Max(10)
    private Integer quantity;

}
