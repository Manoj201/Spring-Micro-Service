package com.cal.sca.model.service;

import com.cal.sca.validation.ProductMustExists;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetProductRequest {

    @NotBlank
    @ProductMustExists
    private String id;
}
