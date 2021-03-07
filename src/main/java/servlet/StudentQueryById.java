package servlet;

import Model.Student;
import dao.StudentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//查询学生住宿详情
@WebServlet("/student/queryById")
public class StudentQueryById extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key=req.getParameter("id");
        Student student= StudentDAO.queryById(Integer.parseInt(key));
        return student;
    }
}
