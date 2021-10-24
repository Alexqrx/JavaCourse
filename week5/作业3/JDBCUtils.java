package com.tgt.common.week05;

import java.sql.*;

public class JDBCUtils {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="tiger";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        //插入
        String s="insert into user(id,user_name,user_password) values(2,?,123)";
        PreparedStatement pst=conn.prepareStatement(s);
        pst.setString(1, "xiaoshuai1");
        pst.execute();
        pst.close();
        conn.close();
        //删除
       /* String s="delete from user where user_name=?";
        PreparedStatement pst=conn.prepareStatement(s);
        pst.setString(1, "xiaoshuai1");
        pst.execute();
        //关闭资源
        pst.close();
        conn.close();*/
        //修改
        /*String s="update user set user_name=? where id=1 ";
        PreparedStatement pst=conn.prepareStatement(s);
        pst.setString(1, "xiaoshuaige");
        pst.execute();
        //关闭资源
        pst.close();
        conn.close();*/
        //查询

        /*String s="select user_name,user_password from user where user_name=? and user_password=?";
        PreparedStatement pst=conn.prepareStatement(s);
        pst.setString(1, "xiao");
        pst.setString(2, "123");
        ResultSet rs=pst.executeQuery();
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" "+rs.getString("user_password"));
        }
        //关闭资源
        rs.close();
        pst.close();
        conn.close();*/

        //批处理，加事务
        conn.setAutoCommit(false);//将自动提交关闭
        PreparedStatement pstmt = conn.prepareStatement("update content set introtext=? where id=?");
        pstmt = conn.prepareStatement("update content set introtext=? where id=?");

        for(int i=0; i<10000; i++){

            //放这里，批处理会执行不了，因为每次循环重新生成了pstmt，不是同一个了

            //pstmt = conn.prepareStatement("update content set introtext=? where id=?");
            pstmt.setString(1, "abc"+i);
            pstmt.setInt(2, i);
            pstmt.addBatch();//添加到同一个批处理中
        }

        pstmt.executeBatch();//执行批处理

        pstmt.close();

        conn.commit();//执行完后，手动提交事务
        conn.setAutoCommit(true);//再把自动提交打开，避免影响其他需要自动提交的操作
        conn.close();
    }
}
