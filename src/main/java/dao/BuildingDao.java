package dao;

import Model.DictionaryTag;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class BuildingDao {
    public static List<DictionaryTag> queryAsDict() {
        List<DictionaryTag> list=new LinkedList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            String sql="select b.id dictionaryTagKey, b.building_name dictionaryTagValue" +
                    "   from building b";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DictionaryTag dt=new DictionaryTag();
                dt.setDictionaryTagValue(rs.getString("dictionaryTagValue"));
                dt.setDictionaryTagKey(rs.getString("dictionaryTagKey"));
                list.add(dt);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询宿舍楼数据字典错误",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return list;
    }
}
