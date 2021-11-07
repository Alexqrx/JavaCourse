package com.week7.jdbc.work1;

import java.sql.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCUtils {
    public static void main(String[] args) throws Exception {
        Connection connection= getConnection();
        //循环插入
        /*long begintime1 =System.currentTimeMillis();
        System.out.println("循环开始插入时间"+begintime1);
        insert(connection);
        long endtime1 =System.currentTimeMillis();
        System.out.println("循环结束插入时间"+endtime1);
        System.out.println("循环时间差"+(endtime1-begintime1));*/
        //批量插入
        long begintime =System.currentTimeMillis();
        System.out.println("批量开始插入时间"+begintime);
        connection.setAutoCommit(false);
        insertBatch(connection);
        connection.commit();
        long endtime =System.currentTimeMillis();
        System.out.println("批量结束插入时间"+endtime);
        System.out.println("批量时间差"+(endtime-begintime));

    }
    //获取数据库链接
    public static Connection getConnection() throws Exception {
        //数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javacourse?rewriteBatchedStatements=true","root","aaa123456!");

    }
    //单个循环插入
    public static void insert(Connection connection) throws SQLException {
        PreparedStatement ps=null;
        try{
            String sql="insert into t_order (order_no,goods_no,user_no,order_sts,order_pay_type) values(?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            for (int i = 1; i <=1000000 ; i++) {
                ps.setString(1,String.valueOf(i));
                ps.setString(2,String.valueOf(i));
                ps.setString(3,String.valueOf(i));
                ps.setString(4,"OR01");
                ps.setString(5,"TR01");
                ps.execute(sql);
            }
        }finally {
            if(ps!=null){
                ps.close();
            }
        }
    }
    //批量插入
    public static void insertBatch(Connection connection) throws Exception {
        PreparedStatement ps=null;
        try{
            String sql="insert into t_order (order_no,goods_no,user_no,order_sts,order_pay_type) values(?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            for (int i = 1; i <=1000000 ; i++) {
                ps.setString(1,String.valueOf(i));
                ps.setString(2,String.valueOf(i));
                ps.setString(3,String.valueOf(i));
                ps.setString(4,"OR01");
                ps.setString(5,"TR01");
                ps.addBatch();
                if(i%10000==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
        }finally {
            if(ps!=null){
                ps.close();
            }
        }
    }


}
