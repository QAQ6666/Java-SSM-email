package cn.beida.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.beida.ssm.dao.service.UserDraftService;

/**
 * Servlet implementation class SaveEmailservlet
 */
@WebServlet("/saveUserEmail")
public class SaveEmailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveEmailservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String endname = request.getParameter("endname");
	    String theme = request.getParameter("theme");
	    String content= request.getParameter("content");
	    HttpSession hs = request.getSession(true);
	    PrintWriter pw = response.getWriter();
	    try {
	       String username = (String) hs.getAttribute("UID");
	      Integer isaveInteger = new UserDraftService().savedraft(username,endname,theme,content);
	       System.out.println(isaveInteger);
	       pw.write(isaveInteger+"");
        }catch (Exception e) {
            e.printStackTrace();
            pw.write("-1");
        }
	}
}
