package cn.beida.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.beida.ssm.controller.filter.Nullfilter;
import cn.beida.ssm.util.email;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FeedbackServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String val = request.getParameter("val");
        System.out.println(val);
	HttpSession session = request.getSession(true);
	String endName = (String) session.getAttribute("UID");
        PrintWriter pw = response.getWriter();
        try {
            email.sendeMail("2606292175@qq.com", "FeedBack"+endName, val);
            pw.write("y");
        } catch (AddressException e) {
            e.printStackTrace();
            pw.write("n");
        } catch (MessagingException e) {
            e.printStackTrace();
            pw.write("n");
        }

    }
}
