package com.week7.jdbc.work3.service.impl;

import com.week7.jdbc.work3.entity.OrderEntity;
import com.week7.jdbc.work3.mapper.OrderMapper;
import com.week7.jdbc.work3.service.OrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public OrderEntity queryById(int id) {
        return orderMapper.findById(id);
    }

    @Override
    public void undifyOrder(OrderEntity orderEntity) {
        orderMapper.updateById(orderEntity);
    }
}
