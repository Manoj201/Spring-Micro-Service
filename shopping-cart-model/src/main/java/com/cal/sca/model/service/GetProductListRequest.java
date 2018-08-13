package com.cal.sca.model.service;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GetProductListRequest {

    private Integer skip;
}
