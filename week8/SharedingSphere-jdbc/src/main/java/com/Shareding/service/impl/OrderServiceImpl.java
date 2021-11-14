package com.Shareding.service.impl;

import com.Shareding.dao.OrderMapper;
import com.Shareding.entity.OrderEntity;
import com.Shareding.service.OrderService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    //单个新增
    @Override
    public void insertOrder(OrderEntity orderEntity) {
        orderMapper.insert(orderEntity);
    }
    //查询单个
    @Override
    public OrderEntity findOneEntity(long id) {
        return orderMapper.selectById(id);
    }
    //删除单个
    @Override
    public void deleteOrderEntity(long id) {
        orderMapper.deleteById(id);
    }
    //更新单个
    @Override
    public int updateOrderEntity(long id) {
        OrderEntity orderEntity= new OrderEntity();
        orderEntity.setId(123456l);
        Timestamp updatetime = new Timestamp(System.currentTimeMillis());
        orderMapper.updateById(orderEntity);
        return 0;
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderMapper.selectList(Wrappers.<OrderEntity>lambdaQuery());
    }
}
