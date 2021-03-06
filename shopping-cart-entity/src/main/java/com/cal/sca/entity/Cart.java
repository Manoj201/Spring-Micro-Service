package com.cal.sca.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document
public class Cart {

    @Id
    private String id;

    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        if(items == null) {
            items = new ArrayList<>();
        }
        return items;
    }
}
