package com.cal.sca.model.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProductModel {

    private String id;

    private String name;

    private Long price;

    private Integer stock;
}
