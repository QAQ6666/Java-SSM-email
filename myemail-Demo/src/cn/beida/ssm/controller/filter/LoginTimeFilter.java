package cn.beida.ssm.controller.filter;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginTimeFilter implements Filter {

    /**
     * 初始化
     */
    public void init(FilterConfig fc) throws ServletException {
        System.out.println("主页过滤启动");
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain chain)
            throws IOException, ServletException {
        if (!(sreq instanceof HttpServletRequest) || !(sresp instanceof HttpServletResponse)) {
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
        HttpServletRequest httpRequest = (HttpServletRequest) sreq;
        HttpServletResponse httpResponse = (HttpServletResponse) sresp;
        httpResponse.setHeader("Cache-Control", "no-cache");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", -1);
        httpResponse.setHeader("P3P", "CP=CAO PSA OUR");

        HttpSession session = httpRequest.getSession();
        System.out.println(session);
        if (!httpResponse.isCommitted()) {
            
            if (session != null) {
                Object object = session.getAttribute("UID");
                String userName = object == null ? null : (String) object;
                if (null == userName || "".equals(userName)) {
                    Nullfilter.serverError(httpRequest, httpResponse,  "用户登录超时或未登录，请重新登录！","logreg.jsp");
                } else {
                    chain.doFilter(httpRequest, httpResponse);
                }
            }
        }
    }
}