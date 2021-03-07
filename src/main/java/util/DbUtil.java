package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    //数据库连接池
    private static volatile DataSource DS;
    private static final String URL="jdbc:mysql://localhost:3306/stu_dorm";
    private static final String USERNAME="root";
    private static final String PASSWORD="740513";
    private  DbUtil(){ }
    private static DataSource getDS(){
        if (DS==null){
            synchronized (DbUtil.class){
                if(DS==null){
                    DS=new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                }
            }
        }
        return DS;
    }
    public static Connection getConnection(){
        try {
            return getDS().getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException("获取数据库失败",throwables);
        }
    }
    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if (r!=null){
                r.close();
            }
            if (s!=null){
                s.close();
            }
            if (c!=null){
                c.close();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("数据库关闭异常",throwables);
        }
    }
    public static void close(Connection c,Statement s){
        close(c,s,null);
    }
}
