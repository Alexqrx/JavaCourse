package com.Shareding.service;

import com.Shareding.entity.OrderEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OrderService extends IService<OrderEntity> {
    void insertOrder(OrderEntity orderEntity);
    OrderEntity findOneEntity(long id);
    void deleteOrderEntity(long id);
    int updateOrderEntity(long id);
    List<OrderEntity> findAll();
}
