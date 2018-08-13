package com.cal.sca.model.service;

import com.cal.sca.validation.ProductMustNotExists;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {

    @ProductMustNotExists
    private String id;

    private String name;

    private Long price;

    private Integer stock;
}
