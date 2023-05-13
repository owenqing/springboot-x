package org.owenqing.springboot.x.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class QueryOrderResp {
    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "price")
    private BigDecimal price;

    private String category;

    @JsonProperty(value = "user_id")
    private Integer userId;
}
