package cn.beida.ssm.controller;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class SendcodeServlet
 */
@WebServlet("/Sendcode")
public class SendcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendcodeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String endName = request.getParameter("email");
	    Nullfilter.reqisNull(endName, request, response);
	    HttpSession session = request.getSession();
	    String val = getStringRandom(5);
	    session.setAttribute("EmailCode", val);
	    try {
            email.sendeMail(endName, "Registration verification code", "Please enter this verification code into the verification code source on the registration page."+"<h1>"+val+"</h1>");
        } catch (AddressException e) {
            Nullfilter.reqisother("alert(\"The server is abnormal, please try again\")", request, response);
        } catch (MessagingException e) {
            Nullfilter.reqisother("alert(\"The server is abnormal, please try again\")", request, response);
        }
	    
	}
	private String getStringRandom(int length) {

	    String val = "";
	    Random random = new Random();

	    //参数length，表示生成几位随机数
	    for(int i = 0; i < length; i++) {

	    String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
	    //输出字母还是数字
	    if( "char".equalsIgnoreCase(charOrNum) ) {
	    //输出是大写字母还是小写字母
	    int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
	    val += (char)(random.nextInt(26) + temp);
	    } else if( "num".equalsIgnoreCase(charOrNum) ) {
	    val += String.valueOf(random.nextInt(10));
	    }
	    }
	    return val;
	    }

}
