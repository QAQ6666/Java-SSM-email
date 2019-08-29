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

import cn.beida.ssm.util.Tokenproduce;

public class SetTokenFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
    /**
     *  设置token，用于防止客户重复提交
     */
    @Override
    public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        String token = Tokenproduce.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token："+token);
        //转换为httpreq
        HttpServletRequest request = (HttpServletRequest)sreq;
        HttpServletResponse response = (HttpServletResponse)sresp;
        
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        request.getRequestDispatcher("/logreg.jsp").forward(request, response);  
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

}
