package cn.beida.ssm.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Errormsgto {
    public static void errormsgto(String msg,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", msg);
        request.getRequestDispatcher("/404.jsp").forward(request, response);
    }
}
