/**
用户表
 */
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user`(
   `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `user_no` varchar(20) DEFAULT NULL COMMENT '用户号',
   `user_name` varchar(10) DEFAULT NULL COMMENT '用户名',
   `password` varchar(32) DEFAULT NULL COMMENT '密码',
   `user_realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
   `address` varchar(255) DEFAULT NULL COMMENT '用户地址',
   `telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
   `user_status` varchar(1) DEFAULT NULL COMMENT '用户状态（0：正常，1：注销）',
   `user_type` varchar(4) DEFAULT NULL COMMENT '用户类别（PR00:普通用户，PR01:会员用户）',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表 ';
/**
商品表
 */
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE IF NOT EXISTS `t_goods`(
   `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `goods_no` varchar(20) DEFAULT NULL COMMENT '商品号',
   `goods_name` varchar(10) DEFAULT NULL COMMENT '商品名称',
   `goods_pic_url` varchar(100) DEFAULT NULL COMMENT '商品图片地址',
   `goods_nums` int(10) DEFAULT NULL COMMENT '商品数量',
   `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
   `goods_describe` varchar(200) DEFAULT NULL COMMENT '商品描述',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '商品表 ';
/**
订单表
 */
 DROP TABLE IF EXISTS `t_order`;
CREATE TABLE IF NOT EXISTS `t_order`(
   `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `order_no` varchar(20) DEFAULT NULL COMMENT '订单编号',
   `goods_no` varchar(20) DEFAULT NULL COMMENT '商品编号',
   `user_no` varchar(20) DEFAULT NULL COMMENT '用户编号',
   `order_sts` varchar(4) DEFAULT NULL COMMENT '订单状态（OR00:初始状态，OR01:已下单，待支付，OR02:已支付，OR03:支付失败，OR04:已退款，OR05:已取消）',
   `order_pay_type` varchar(4) DEFAULT NULL COMMENT '支付方式（TR00:支付宝，TR01:微信，TR02:其他）',
   `order_money` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
   `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '订单表 ';