package filter;

import Model.Response;
import util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        //页面的静态资源，后台服务
        //需要处理的敏感资源
        //1.首页== /public/page/main.html  没有登陆则重定向到登录页面
        //2.后端服务资源  == /user/login 除了这个接口以外的没有登录时，则返回错误信息（没有登陆的json信息）

        //获取session信息
        HttpSession session= req.getSession(false);
        if (session==null){//没有登陆
            //获取当前http请求路径
            String uri=req.getServletPath();
            if ("/public/page/main.html".equals(uri)){
                //首页没有登录执行重定向
                String schema=req.getScheme();//http
                String host=req.getServerName();//服务器域名  或者  ip
                int port=req.getServerPort();//服务器端口号
                String contextPath=req.getContextPath();//项目部署名
                String basepath=schema+"://"+host+":"+port+contextPath;
                res.sendRedirect(basepath+"/public/index.html");
                return;
            }else if (!"/user/login".equals(uri)&&!uri.startsWith("/public/")&&!uri.equals("/static/")){
                //既不是登录接口,也不是/public.开头的静态资源,也不是/static/开头的静态资源,所以一定要返回错误的json数据
                //返回json数据
                req.setCharacterEncoding("UTF-8");//设置请求数据的编码格式
                res.setCharacterEncoding("UTF-8");//设置响应数据的编码格式
                res.setContentType("application/json");//设置响应数据格式
                Response r=new Response();
                r.setCode("301");//响应体的字段
                r.setMessage("未授权的http请求");
                PrintWriter pw=res.getWriter();
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }
        }
        //过滤器向下调用，再次过滤
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
