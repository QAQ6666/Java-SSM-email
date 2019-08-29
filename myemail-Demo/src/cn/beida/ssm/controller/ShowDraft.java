package cn.beida.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.beida.ssm.dao.service.UserDraftService;

/**
 * Servlet implementation class ShowDraft
 */
@WebServlet("/ShowDraft")
public class ShowDraft extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDraft() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession hs = request.getSession(true);
	    PrintWriter pw = response.getWriter();
	    try {
	        int deid = (int) hs.getAttribute("eid");
	        List list = new UserDraftService().inquireDraft(deid);
//	      list转化为json
	        String liststr =  JSON.toJSONString(list);
	        pw.write(liststr);
        } catch (Exception e) {
            pw.write("System error, please try again");
        }
	}

}
