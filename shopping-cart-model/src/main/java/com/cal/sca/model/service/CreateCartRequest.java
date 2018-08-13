package com.cal.sca.model.service;

import com.cal.sca.validation.CartMustNotExists;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCartRequest {

    @CartMustNotExists
    private String id;
}
