package servlet;

import Model.Student;
import dao.StudentDAO;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//分配学生住宿信息
@WebServlet("/student/apply")
public class StudentApplyServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s= JSONUtil.read(req.getInputStream(), Student.class);
        int num= StudentDAO.apply(s);
        return num;
    }
}
