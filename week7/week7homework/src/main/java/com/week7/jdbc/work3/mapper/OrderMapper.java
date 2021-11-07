package com.week7.jdbc.work3.mapper;

import com.week7.jdbc.work3.entity.OrderEntity;

public interface OrderMapper {
    OrderEntity findById(int id);
    void updateById(OrderEntity orderEntity);
}
