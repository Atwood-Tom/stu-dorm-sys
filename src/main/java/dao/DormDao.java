package dao;

import Model.DictionaryTag;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DormDao {
    public static List<DictionaryTag> queryAsDict(String key) {
        List<DictionaryTag> list=new LinkedList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            String sql="select d.id Id, d.dorm_no dormNo" +
                    "   from dorm d" +
                    "   where d.building_id = ?";
            ps=c.prepareStatement(sql);
            ps.setString(1,key);
            rs=ps.executeQuery();
            while(rs.next()){
                DictionaryTag dt=new DictionaryTag();
                dt.setDictionaryTagKey(rs.getString("Id"));
                dt.setDictionaryTagValue(rs.getString("dormNo"));
                list.add(dt);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询宿舍出错",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return list;
    }
}
