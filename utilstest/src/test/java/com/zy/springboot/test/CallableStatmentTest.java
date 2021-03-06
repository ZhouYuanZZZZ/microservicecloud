package com.zy.springboot.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * 调用储存过程示例代码*/
public class CallableStatmentTest {

    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3307/hr";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(URL, USERNAME,
                PASSWORD);

        String sql = "{CALL test_procedure0(?,?)}"; //调用存储过程

        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm
        cstm.setInt(1, 10);
        cstm.registerOutParameter(2, Types.INTEGER); // 设置返回值类型

        cstm.execute(); // 执行存储过程
        System.out.println(cstm.getInt(2));

        cstm.close();
        connection.close();
    }

}
