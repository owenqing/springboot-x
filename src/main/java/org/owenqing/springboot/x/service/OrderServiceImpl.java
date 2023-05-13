package org.owenqing.springboot.x.service;

import org.owenqing.springboot.x.dao.OrderInfoDao;
import org.owenqing.springboot.x.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderInfoDao orderInfoDao;

    @Override
    public OrderInfo queryOrderById(Integer orderId) {
        return orderInfoDao.queryOrder(orderId);
    }
}
