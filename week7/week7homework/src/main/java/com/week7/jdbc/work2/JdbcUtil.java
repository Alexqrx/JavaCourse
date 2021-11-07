package com.week7.jdbc.work2;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    static Properties properties = null;
    public JdbcUtil(String rw){
        //读取属性文件
        properties = new Properties();
        InputStream in = null;
        if(rw.equals("R")){
            in = (InputStream) this.getClass().getResourceAsStream("/mysqlDBRead.properties");
        }else if(rw.equals("W")){
            in = (InputStream) this.getClass().getResourceAsStream("/mysqlDBWrite.properties");
        }
        try{
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        Connection conn=null;
        try{
            Class.forName(properties.getProperty("driverClass"));
            conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws Exception {
        PreparedStatement ps;
        ResultSet rs;
        Connection connection;
        JdbcUtil util=null;
        //读操作
        util=new JdbcUtil("R");
        connection=util.getConn();
        String sqlquery="select * from t_order where id=?";
        ps=connection.prepareStatement(sqlquery);
        ps.setString(1,"2999979");
        rs=ps.executeQuery();
        if(rs.next()){
            System.out.println(rs.getString("order_no"));
        }
        rs.close();
        connection.close();
        ps.close();
        //写操作
        /*JdbcUtil utilw=new JdbcUtil("R");
        connection=util.getConn();
        String sqlup="update t_order set order_sts=? where id=?";
        ps=connection.prepareStatement(sqlup);
        ps.setString(1,"OR05");
        ps.setString(2,"2999979");
        int i=ps.executeUpdate();
        if(i>0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
        connection.close();
        ps.close();*/
    }

}
