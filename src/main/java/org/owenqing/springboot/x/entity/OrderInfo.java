package org.owenqing.springboot.x.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfo {
    private Integer id;

    private BigDecimal price;

    private String category;

    private Integer userId;
}
