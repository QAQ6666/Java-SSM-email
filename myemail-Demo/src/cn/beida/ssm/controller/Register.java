package cn.beida.ssm.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.beida.ssm.controller.filter.Md5pwdFilter;
import cn.beida.ssm.controller.filter.Nullfilter;
import cn.beida.ssm.dao.service.EmailuserService;
import cn.beida.ssm.dao.service.UserService;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("注册");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pwdAGAIN = request.getParameter("pwdAGAIN");
        String code = request.getParameter("code");
        Nullfilter.reqisNull(username, request, response);
        Nullfilter.reqisNull(email, request, response);
        Nullfilter.reqisNull(password, request, response);
        Nullfilter.reqisNull(pwdAGAIN, request, response);
        Nullfilter.reqisNull(code, request, response);
        HttpSession session = request.getSession();
        String emailCode = (String) session.getAttribute("EmailCode");
        if (code.equals(emailCode)) {
            String istrue = new UserService().seleuname(username);
            if (istrue != null)
                Nullfilter.reqisother("alert(\"This username has been registered\")", request, response);
            istrue = new EmailuserService().seleEmail(email);
            if (istrue != null)
                Nullfilter.reqisother("alert(\"The mailbox has been registered\")", request, response);
            // 用户名和邮箱不重复，开始插入新数据
            Integer idInteger = new EmailuserService().addNew(email, username);
            if(idInteger==-1) {
                Nullfilter.reqisother("alert(\"Registration is abnormal, please try again\")", request, response);
            }
            try {
                password = Md5pwdFilter.EncoderByMd5(password);
            } catch (NoSuchAlgorithmException e) {
                Nullfilter.reqisother("alert(\"System exception\")", request, response);
            }
            int id = new UserService().saveuser(idInteger, username, password);
            if (id > 0) {
                Nullfilter.reqisother("alert(\"Registration is successful, go log in\")", request, response);
            } else {
                Nullfilter.reqisother("alert(\"Registration failed, please try again\")", request, response);
            }
        } else {
            Nullfilter.reqisother("alert(\"Incorrect verification code\")", request, response);
        }

    }

}
