package org.owenqing.springboot.x.service;

import org.owenqing.springboot.x.entity.OrderInfo;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderInfo queryOrderById(Integer orderId);
}
