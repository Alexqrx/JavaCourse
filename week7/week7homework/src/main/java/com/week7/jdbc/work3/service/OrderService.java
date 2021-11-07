package com.week7.jdbc.work3.service;

import com.week7.jdbc.work3.entity.OrderEntity;

public interface OrderService {
    OrderEntity queryById(int id);

    void undifyOrder(OrderEntity orderEntity);
}
