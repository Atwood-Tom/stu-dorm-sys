package servlet;


import Model.DictionaryTag;
import dao.DormDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


//查询寝室
@WebServlet("/dorm/queryAsDict")
public class DormQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key=req.getParameter("dictionaryKey");
        List<DictionaryTag> list= DormDao.queryAsDict(key);
        return list;
    }
}
