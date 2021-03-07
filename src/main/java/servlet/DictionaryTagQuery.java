package servlet;

import Model.DictionaryTag;
import dao.DictionaryTagDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
//查询毕业年份字典    或者     查询专业字典
@WebServlet("/dict/tag/query")
public class DictionaryTagQuery extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key=req.getParameter("dictionaryKey");
        List<DictionaryTag> list= DictionaryTagDao.query(key);
        return list;
    }
}
