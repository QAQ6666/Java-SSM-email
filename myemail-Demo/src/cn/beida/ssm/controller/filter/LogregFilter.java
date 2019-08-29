package cn.beida.ssm.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogregFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 禁止缓存
        res.setHeader("Cache-Control", "no-store");
        res.setHeader("Pragrma", "no-cache");
        res.setDateHeader("Expires", 0);
        // 链接来源地址
        String referer = req.getHeader("referer");
        System.out.println("refer is" + referer);
        if (referer == null || !referer.contains(request.getServerName())) {
            request.setAttribute("errormsg", "非法请求或服务器异常");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("logregFilter");
    }

}
