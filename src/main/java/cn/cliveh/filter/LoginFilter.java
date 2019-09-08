package cn.cliveh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录验证的过滤器
 *
 * @author CliveH
 * @date 2019/07/19
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //设置请求与响应的字符解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //将不需要过滤的请求存放到集合中
        List<String> pathList = new ArrayList<String>();
        pathList.add("/about");
        pathList.add("/article");
        pathList.add("/archive");
        pathList.add("/home");
        pathList.add("/index");
        pathList.add("/login");
        pathList.add("/tags");
        pathList.add("/checkCode");
        pathList.add("/getBingImgUrl");
        pathList.add("/findTitle");
        pathList.add("/saveComment");
        pathList.add("/404");
        pathList.add("/css/");
        pathList.add("/js/");
        pathList.add("/img/");
        pathList.add("/editormd/");
        pathList.add("/fonts/");

        //获取资源请求路径
        String uri = request.getRequestURI();

        //循环集合把不需要过滤的请求放行
        for (String path : pathList) {
            if (uri.contains(path) || "/".equals(uri)) {
                chain.doFilter(request, response);
                return;
            }
        }

        //要过滤，验证是否已经登录
        //从session中获取user
        Object adminUser = request.getSession().getAttribute("adminUser");
        if (adminUser != null) {
            //已登录，放行
            chain.doFilter(request, response);
        } else {
            //没有登录，跳转到登录页面
            request.setAttribute("login_msg", "您尚未登录，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
