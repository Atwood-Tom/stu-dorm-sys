package dao;

import Model.Page;
import Model.Student;
import util.DbUtil;
import util.ThreadLocalHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {

    public static List<Student> query() {
        List<Student> list=new LinkedList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            String sql="select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id buildingId," +
                    "       b.building_name" +
                    "       from student s," +
                    "       dorm d," +
                    "       building b" +
                    "       where dorm_id = s.dorm_id" +
                    "       and d.building_id = b.id" ;
                   
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentGraduateYear(rs.getString("student_graduate_year"));
                student.setStudentMajor(rs.getString("student_major"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setDormId(rs.getInt("dorm_id"));
                student.setCreateTime(rs.getTime("create_time"));
                student.setDormNo(rs.getString("dorm_no"));
                student.setBuildingId(rs.getInt("buildingId"));
                student.setBuildingName(rs.getString("building_name"));
                list.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("????????????????????????",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return list;
    }


    public static Student queryById(int id) {
        Student student=new Student();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            String sql="select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id buildingId," +
                    "       b.building_name" +
                    "   from student s" +
                    "         join dorm d on dorm_id = s.dorm_id" +
                    "         join building b on d.building_id = b.id" +
                    "   where s.id=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentGraduateYear(rs.getString("student_graduate_year"));
                student.setStudentMajor(rs.getString("student_major"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setDormId(rs.getInt("dorm_id"));
                student.setCreateTime(rs.getTime("create_time"));
                student.setDormNo(rs.getString("dorm_no"));
                student.setBuildingId(rs.getInt("buildingId"));
                student.setBuildingName(rs.getString("building_name"));
            }
        } catch (Exception e) {
            throw new RuntimeException("??????????????????",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return student;
    }

    public static int insert(Student s) {
        //?????????????????????JDBC???????????????????????????
        Connection c = null;
        PreparedStatement ps = null;
        //?????????????????????ResultSet??????
//        ResultSet rs = null;
        try {
            //???????????????????????????
            c = DbUtil.getConnection();
            String sql = "insert into student(student_name,student_graduate_year,student_major,student_email,dorm_id) values (?,?,?,?,?)";
            //???????????????????????????ps??????
            ps = c.prepareStatement(sql);
            //???????????????
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentGraduateYear());
            ps.setString(3,s.getStudentMajor());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getDormId());
            //???????????????(?????????)
//            rs = ps.executeQuery();
            //????????????,???????????????????????????
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("????????????????????????",e);
        } finally {
            //????????????
            DbUtil.close(c,ps);
        }
    }

    public static int update(Student s) {
        //?????????????????????JDBC???????????????????????????
        Connection c = null;
        PreparedStatement ps = null;
        //?????????????????????ResultSet??????
//        ResultSet rs = null;
        try {
            //???????????????????????????
            c = DbUtil.getConnection();
            String sql = "update student set student_name=?,student_graduate_year=?,student_major=?,student_email=?,dorm_id=? where id=?";
            //???????????????????????????ps??????
            ps = c.prepareStatement(sql);
            //???????????????
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentGraduateYear());
            ps.setString(3,s.getStudentMajor());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getDormId());
            ps.setInt(6,s.getId());
            //???????????????(?????????)
//            rs = ps.executeQuery();
            //????????????,???????????????????????????
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("????????????????????????",e);
        } finally {
            //????????????
            DbUtil.close(c,ps);
        }
    }

    public static int delete(String[] ids) {
        //?????????????????????JDBC???????????????????????????
        Connection c = null;
        PreparedStatement ps = null;
        //?????????????????????ResultSet??????
//        ResultSet rs = null;
        try {
            //???????????????????????????
            c = DbUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from student where id in (");
            //??????SQL?????????
            for(int i = 0;i < ids.length;i++){
                if(i != 0){
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");
            //???????????????????????????ps??????
            ps = c.prepareStatement(sql.toString());
            //???????????????
            for(int i = 0;i < ids.length;i++){
                ps.setInt(i + 1,Integer.parseInt(ids[i]));
            }
            //???????????????(?????????)
//            rs = ps.executeQuery();
            //????????????,???????????????????????????
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("????????????????????????",e);
        } finally {
            //????????????
            DbUtil.close(c,ps);
        }

    }

    public static int Delete(String[] ids) {
        Connection c=null;
        PreparedStatement ps=null;
        try {
            c=DbUtil.getConnection();
            StringBuilder sql=new StringBuilder("delete from student where id in (");
            for (int i=0;i<ids.length;i++){
                if (i==0){
                    sql.append("?");
                }else {
                    sql.append(",?");
                }
            }
            sql.append(')');
            ps=c.prepareStatement(sql.toString());
            for (int i=0;i<ids.length;i++){
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("??????????????????",e);
        } finally {
            DbUtil.close(c,ps);
        }
    }

    public static int apply(Student s) {
        List<Integer> ids=s.getIds();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c=DbUtil.getConnection();
            StringBuilder sql=new StringBuilder("update student set dorm_id= ? " +
                    "where id in(");
            for (int i=0;i<ids.size();i++){
                if (i==0){
                    sql.append("?");
                }else {
                    sql.append(",?");
                }
            }
            sql.append(')');
            ps=c.prepareStatement(sql.toString());
            ps.setInt(1,s.getDormId());
            for (int i=0;i<ids.size();i++){
                ps.setInt(i+2,ids.get(i));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("??????????????????",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
    }

    public static List<Student> query(Page p) {
        List<Student> list=new LinkedList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DbUtil.getConnection();
            StringBuilder sql=new StringBuilder("select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id buildingId," +
                    "       b.building_name" +
                    "       from student s," +
                    "       dorm d," +
                    "       building b" +
                    "       where dorm_id = s.dorm_id" +
                    "       and d.building_id = b.id" );
            if (p.getSearchText()!=null&&p.getSearchText().trim().length()>0){
                sql.append("    where s.student_name like ?");
            }
            if (p.getSortOrder()!=null&&p.getSortOrder().trim().length()>0){
                //???????????????????????????????????????????????????????????????????????????
                sql.append("    order by s.create_time "+p.getSortOrder());
            }

            StringBuilder countSQL=new StringBuilder("select count(0) count from (");
            countSQL.append(sql);
            countSQL.append(") tmp");

            ps=c.prepareStatement(countSQL.toString());
            if (p.getSearchText()!=null&&p.getSearchText().trim().length()>0){
                ps.setString(1,"%"+p.getSearchText()+"%");
            }
            rs=ps.executeQuery();
            while(rs.next()){
                //TODO
                int count =rs.getInt("count");//???????????????total??????????????????????????????????????????????????????
                //??????ThreadLocal ????????????????????????
                ThreadLocalHolder.getThreadLocal().set(count);//?????????????????????Thread??????ThreadLocalMap??????????????????
            }

            //??????????????????
            sql.append("    limit ?,?");
            ps=c.prepareStatement(sql.toString());
            //???????????????
            //?????????????????????(?????????0??????)
            int start=(p.getPageNumber()-1)*p.getPageSize();
            int i=1;
            if (p.getSearchText()!=null&&p.getSearchText().trim().length()>0){
                ps.setString(i++,"%"+p.getSearchText()+"%");
            }
            ps.setInt(i++,start);
            ps.setInt(i++,p.getPageSize());
            rs=ps.executeQuery();
            while (rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentGraduateYear(rs.getString("student_graduate_year"));
                student.setStudentMajor(rs.getString("student_major"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setDormId(rs.getInt("dorm_id"));
                student.setCreateTime(rs.getTime("create_time"));
                student.setDormNo(rs.getString("dorm_no"));
                student.setBuildingId(rs.getInt("buildingId"));
                student.setBuildingName(rs.getString("building_name"));
                list.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("????????????????????????",e);
        } finally {
            DbUtil.close(c,ps,rs);
        }
        return list;
    }
}
