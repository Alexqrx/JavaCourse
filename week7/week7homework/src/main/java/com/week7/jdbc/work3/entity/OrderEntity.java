package com.week7.jdbc.work3.entity;

import lombok.Data;

@Data
public class OrderEntity {
    private int id;
    private String goods_no;
    private String order_no;
    private String user_no;
    private String order_sts;
    private String order_pay_type;
}
