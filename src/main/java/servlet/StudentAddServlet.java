package servlet;


import Model.Student;
import dao.StudentDAO;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//新增学生住宿信息
@WebServlet("/student/add")
public class StudentAddServlet extends AbstractBaseServlet{
   @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       Student s= JSONUtil.read(req.getInputStream(), Student.class);
       int num= StudentDAO.insert(s);
       return null;
    }
}
