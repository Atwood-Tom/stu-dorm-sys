package dao;

import Model.User;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public static User query(User user) {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User queryUser=null;
        try {
            c= DbUtil.getConnection();
            String sql="select id, username, password, nickname, email, create_time" +
                    "   from user" +
                    "   where username = ?" +
                    "   and password = ?; ";
            ps=c.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                queryUser=user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
                queryUser.setEmail(rs.getString("email"));
                queryUser.setCreateTime(rs.getDate("create_time"));
            }
        } catch (Exception e) {
            throw new RuntimeException("登陆中校验用户名密码出错",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return queryUser;
    }
}
