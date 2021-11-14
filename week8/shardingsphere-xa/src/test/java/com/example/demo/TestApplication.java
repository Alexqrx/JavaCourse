package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {
    @Autowired
    UserService userService;

    @Test
    @ShardingTransactionType(TransactionType.XA)
    public void insertuser(){
        User user= new User();
        user.setId(22222222);
        user.setName("name");
        user.setAge(1);
        userService.insertuser(user);

        User user1= new User();
        user1.setId(22222223);
        user1.setName("name");
        user1.setAge(2);
        userService.insertuser(user1);
        userService.insertuser(user);//这里会报错，因为在分布式事务中，因此user1、user都会插入失败,commit失败后所有的事务都会回滚。
    }
}
