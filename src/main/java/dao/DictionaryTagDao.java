package dao;

import Model.DictionaryTag;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DictionaryTagDao {
    public static List<DictionaryTag> query(String key) {
        List<DictionaryTag> list=new LinkedList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            String sql="select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "         join dictionary_tag dt" +
                    "              on d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ? ";
            ps=c.prepareStatement(sql);
            ps.setString(1,key);
            rs=ps.executeQuery();
            while(rs.next()){
                //concat在数据库中用来拼接两个字符串
                DictionaryTag dt=new DictionaryTag();
                dt.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                dt.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                list.add(dt);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典标签出错,DictionaryTagDao",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return list;
    }
}
