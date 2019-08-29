package cn.beida.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.Application;

import cn.beida.ssm.controller.filter.Nullfilter;

/**
 * Servlet implementation class LoginOutServlet
 */
@WebServlet("/logout")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginOutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //用户注销
	    PrintWriter out = null;
	    try {
	        HttpSession session = request.getSession(true);// 取得session对象
	        session.removeAttribute("UID");
	         out = response.getWriter();
	        out.print("true");
	        Nullfilter.reqisother("Logout successful", request, response);
        } catch (Exception e) {
            out.print("false");
            e.printStackTrace();
        }
	   
	    
	}

}
