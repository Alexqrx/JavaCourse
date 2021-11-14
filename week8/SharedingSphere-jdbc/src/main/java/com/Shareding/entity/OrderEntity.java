package com.Shareding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@TableName("t_order")
public class OrderEntity extends Model<OrderEntity> {
    @TableId(value="id")
    Long id;
    String order_no;
    String goods_no;
    Long user_no;
    String order_sts;
    String order_pay_type;
    BigDecimal order_money;
    Timestamp pay_time;
    Timestamp create_time;
    Timestamp update_time;
}
