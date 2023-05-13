package org.owenqing.springboot.x.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryOrderReq {
    @JsonProperty(value = "id")
    private Integer ID;
}
