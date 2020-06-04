package com.atguigu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作数据库连接(从连接池中获取)
 */
public class JdbcUtils {

    static DruidDataSource dataSource;

    static {
        try {
            //创建属性配置文件类
            Properties properties = new Properties();
            // 通过类加载器,读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            properties.load(inputStream);
            // 根据属性连接信息创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     *从数据库连接池中获取连接 <br/>
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            // 从数据库连接池中获取连接
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接,放回连接池中
     * @param conn
     */
    public static void close(Connection conn){
        if (conn != null) {
            try {
                // 把连接放回数据库连接池中
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
