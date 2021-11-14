package com.Shareding;

import com.Shareding.entity.OrderEntity;
import com.Shareding.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShadingjdbcApplicationTests {


    @Autowired
    OrderService orderService;


    //查一个
    @Test
    public void getOrderByid(){
       OrderEntity orderEntity= orderService.findOneEntity(1459752245682782209l);
       System.out.println("orderEntity"+orderEntity);
    }
    //查所有
    @Test
    public void getAllOrder(){
        List<OrderEntity> orderEntity= orderService.findAll();
        System.out.println("orderEntity"+orderEntity);
    }
    //插入
    @Test
    public void insertOrder(){
        for (int i = 0; i <100 ; i++) {
            Timestamp tp=new Timestamp(System.currentTimeMillis());
            OrderEntity orderEntity=new OrderEntity();
            orderEntity.setUser_no(System.currentTimeMillis());
            orderEntity.setGoods_no("G"+String.valueOf(System.currentTimeMillis()));
            orderEntity.setOrder_no("O"+String.valueOf(System.currentTimeMillis()));
            orderEntity.setOrder_sts("OR00");
            orderEntity.setOrder_pay_type("PR01");
            orderEntity.setPay_time(tp);
            orderEntity.setCreate_time(tp);
            orderEntity.setUpdate_time(tp);
            orderService.insertOrder(orderEntity);
        }
    }
    //修改
    @Test
    public void updateOrder(){
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setId(1459752247318560769l);
        orderEntity.setOrder_sts("OR01");
        orderService.updateById(orderEntity);
    };
    //删除
    @Test
    public void deleteOrder(){
        OrderEntity orderEntity=new OrderEntity();
        orderService.deleteOrderEntity(1459752247318560769l);
    }
}