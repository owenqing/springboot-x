package org.owenqing.springboot.x.controller;

import lombok.val;
import org.owenqing.springboot.x.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.owenqing.springboot.x.request.QueryOrderReq;
import org.owenqing.springboot.x.response.QueryOrderResp;


@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/query_order")
    public QueryOrderResp queryOrder(@RequestBody QueryOrderReq request) {
        Integer orderId = request.getID();
        val orderInfo = orderService.queryOrderById(orderId);
        // response
        QueryOrderResp response = new QueryOrderResp();
        if (orderInfo == null) return response;
        response.setId(orderInfo.getId());
        response.setPrice(orderInfo.getPrice());
        response.setCategory(orderInfo.getCategory());
        response.setUserId(orderInfo.getUserId());
        return response;
    }
}
