package cn.beida.ssm.controller;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.beida.ssm.controller.filter.Nullfilter;
import cn.beida.ssm.dao.service.RecordingemailService;
import cn.beida.ssm.util.Filestorage;
import cn.beida.ssm.util.email;

/**
 * Servlet implementation class SendemailServlet
 */
@WebServlet("/Sendemail")
public class SendemailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SendemailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 取得用户对象的用户名
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("UID");
        // 获得当前时间
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 判断提交上来的数据是否是上传表单的数据
        boolean ismu = ServletFileUpload.isMultipartContent(request);

        try {
            Map<String, String> isupload= null;
            String endName = null;
            String theme = null;
            String content = null;
            if (ismu) {
                // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
                String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
                // 上传时生成的临时文件保存目录
                String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
                File tmpFile = new File(tempPath);
                if (!tmpFile.exists()) {
                    // 创建临时目录
                    tmpFile.mkdir();
                }
                // 0代表上传图片 (base64)，1代表上传其他文件(文件存储路径)
               isupload = Filestorage.storageSQL(tmpFile, tempPath, savePath, request, response);
               //表达数据获取
                endName = isupload.get("recipient");
                theme = isupload.get("theme");
                content = isupload.get("content");
                
                if (isupload == null) {
                    throw new NullPointerException();
                } else if (isupload.get("0").equals("img")) {
                    Integer num = new RecordingemailService().saveEmail(username, "", isupload.get("filenbase"), content,
                            dateStr, theme,isupload.get("filename"));
                    
                    if (num <= 0) {
                        Nullfilter.toIndex("alert(\"The server is abnormal, please try again\")", request, response);
                    }
                    //发送包含图片的邮件
                    email.sendIMGEmail(endName, theme, content, isupload.get("filenbase"));

                } else if (isupload.get("0").equals("file")) {
                    Integer num = new RecordingemailService().saveEmail(username, isupload.get("filepath"), "", content,
                            dateStr, theme,"");
                    if (num <= 0) {
                        Nullfilter.toIndex("alert(\"The server is abnormal, please try again\")", request, response);
                    }
                    //发送包含文件的邮件
                    email.sendFileEmail(endName, theme, content, isupload.get("filepath"));
                    
                } else {
                    Integer num = new RecordingemailService().saveEmail(username, "", "", content,
                            dateStr, theme,"");
                    if (num <= 0) {
                        Nullfilter.toIndex("alert(\"The server is abnormal, please try again\")", request, response);
                    }
                    //发送普通邮件
                    email.sendeMail(endName,theme,content);
                }
                Nullfilter.toIndex("alert(\"Send successfully\")", request, response);
            }
        }catch (NullPointerException e) {
            Nullfilter.serverError(request, response, "Server exception,Please try again","index.jsp");
        } catch (MessagingException e) {
            Nullfilter.serverError(request, response, "Failed to send,Please try again！","index.jsp");
        } catch (SQLException e) {
            Nullfilter.serverError(request, response, "The operation failed, please try again","index.jsp");
        }
    }

}
