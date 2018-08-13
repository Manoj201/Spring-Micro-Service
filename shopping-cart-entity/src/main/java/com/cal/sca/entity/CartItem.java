package com.cal.sca.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {

    private String id;

    private String name;

    private Long price;

    private Integer quantity;
}
