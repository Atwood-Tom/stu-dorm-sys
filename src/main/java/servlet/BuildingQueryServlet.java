package servlet;

import Model.DictionaryTag;
import dao.BuildingDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//查询宿舍楼
@WebServlet("/building/queryAsDict")
public class BuildingQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<DictionaryTag> list= BuildingDao.queryAsDict();
        return list;
    }
}
