package cn.beida.ssm.controller.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Nullfilter {
  public static void reqisNull(String judge,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
          if (judge.equals("")) {
              req.setAttribute("errormsg", "alert(\"Input error or exception, please try again\")");
              req.getRequestDispatcher("/logreg.jsp").forward(req, resp);
          }
    } catch (NullPointerException e) {
        req.setAttribute("errormsg", "alert(\"Input error or exception, please try again\")");
        req.getRequestDispatcher("/logreg.jsp").forward(req, resp);
    }
      
  }
  public static void reqInputerr(HttpServletRequest req, HttpServletResponse resp,String toaddress) throws ServletException, IOException {
          req.setAttribute("errormsg", "alert(\"wrong user name or password\")");
          req.getRequestDispatcher(toaddress).forward(req, resp);
  }
  public static void serverError(HttpServletRequest req, HttpServletResponse resp,String erroeMsg,String address) throws ServletException, IOException {
          req.setAttribute("errormsg", erroeMsg);
          req.setAttribute("address",address);
          req.getRequestDispatcher("/error.jsp").forward(req, resp);
  }
  public static void reqisother(String judge,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setAttribute("errormsg", judge);
          req.getRequestDispatcher("/logreg.jsp").forward(req, resp);
  }
  public static void toIndex(String judge,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setAttribute("msg", judge);
      req.getRequestDispatcher("/index.jsp").forward(req, resp);
  }
}
