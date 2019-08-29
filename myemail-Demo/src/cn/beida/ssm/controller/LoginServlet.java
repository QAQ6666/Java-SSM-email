package cn.beida.ssm.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.beida.ssm.controller.filter.Md5pwdFilter;
import cn.beida.ssm.controller.filter.Nullfilter;
import cn.beida.ssm.controller.filter.SpecialfontFilter;
import cn.beida.ssm.dao.service.EmailuserService;
import cn.beida.ssm.dao.service.RecordingemailService;
import cn.beida.ssm.dao.service.UserService;
import cn.beida.ssm.pojo.Emailuser;
import cn.beida.ssm.pojo.Recordingemail;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean b = isRepeatSubmit(request);// 判断用户是否是重复提交
        String toaddressString = "/logreg.jsp";
        if (b == true) {
            request.setAttribute("errormsg", "alert(\"Please do not repeat the request\")");
            request.getRequestDispatcher(toaddressString).forward(request, response);
            toaddressString = null;
            return;
        }
        request.getSession().removeAttribute("token");// 移除session中的token

        String nameString = request.getParameter("username");
        String pwdString = request.getParameter("password");
        Nullfilter.reqisNull(nameString, request, response);
        Nullfilter.reqisNull(pwdString, request, response);
        
        if (nameString == null || !nameString.equals(SpecialfontFilter.stringFilter(nameString))
                || nameString.equals("")) {
            Nullfilter.serverError(request, response,"llegal character, request failed","logreg.jsp");
        }
        boolean islogin = true;
        Emailuser eid = null;
        try {
            pwdString = Md5pwdFilter.EncoderByMd5(pwdString);
            islogin = new UserService().loginto(nameString, pwdString);
            eid=  new EmailuserService().seleEid(nameString);
        } catch (NullPointerException e) {
            islogin = false;
            Nullfilter.reqInputerr( request, response,toaddressString);
        } catch (NoSuchAlgorithmException e) {
            islogin = false;
            Nullfilter.reqInputerr( request, response,toaddressString);
        }
        if (islogin) {
            HttpSession session = request.getSession(true);// 取得session对象
            session.setAttribute("eid", eid.getEid());
            session.setAttribute("UID", nameString);
          //查询用户的发送记录
            List<Recordingemail> list = new RecordingemailService().seleRecording(nameString);
            session.setAttribute("recordingLIST", list);
           
            String path = request.getContextPath();
            toaddressString = null;
            response.sendRedirect(path + "/index.jsp");
        }
    }

    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * 
     * @param request
     * @return true 用户重复提交了表单 false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        // 1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if (client_token == null) {
            return true;
        }
        // 取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        // 2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if (server_token == null) {
            return true;
        }
        // 3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if (!client_token.equals(server_token)) {
            return true;
        }

        return false;
    }
}
