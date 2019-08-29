package cn.beida.ssm.util;

import javax.activation.DataHandler;

import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class email implements Job {
    private final static Properties properties;
    private final static String AUTHORIZATIONtCODE = "mkrmyskneakzdhje";
    private final static String SENDER = "2606292175@qq.com";

    static {
        // 做链接前的准备工作 也就是参数初始化
        properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.qq.com");// 发送邮箱服务器
        properties.setProperty("mail.smtp.port", "465");// 发送端口
        properties.setProperty("mail.smtp.auth", "true");// 是否开启权限控制
        properties.setProperty("mail.debug", "true");// true 打印信息到控制台
        properties.setProperty("mail.transport", "smtp");// 发送的协议是简单的邮件传输协议
        properties.setProperty("mail.smtp.ssl.enable", "true");

    }

    /**
     * 发送普通邮箱方法
     * @return
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendeMail(String endName, String theme, String content)
            throws AddressException, MessagingException {
        // 建立两点之间的链接
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, AUTHORIZATIONtCODE);
            }
        });
        // 创建邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(SENDER));
        // 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(endName));
        // 设置主题
        message.setSubject(theme);
        // 设置邮件正文 第二个参数是邮件发送的类型
        message.setContent(content, "text/html;charset=UTF-8");
        // 发送一封邮件
        Transport transport = session.getTransport();
        transport.connect(SENDER, AUTHORIZATIONtCODE);
        Transport.send(message);
    }

    /**
     * 发送图片的邮箱方法
     * @return
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendIMGEmail(String endName, String theme, String content, String filename)
            throws AddressException, MessagingException {

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, AUTHORIZATIONtCODE);
            }
        });
        // 创建邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(SENDER));
        // 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(endName));// 收件人
        // 设置主题
        message.setSubject(theme);
        // 设置邮件正文 第二个参数是邮件发送的类型
        /*
         * 邮件内容的创建：图片和附件
         */
        // 创建文本节点
        MimeBodyPart text = new MimeBodyPart();
        // 将图片包含到文本内容中
        text.setContent(content + "<br/><img src='data:image/png;base64," + filename + "'/>",
                "text/html;charset=UTF-8");

        // 将文本和图片节点结合
        MimeMultipart text_image = new MimeMultipart();
        text_image.addBodyPart(text);
        // text_image.addBodyPart(image);
        text_image.setSubType("related"); // 关联关系 有内嵌资源要定义related

        // 将混合节点封装成普通节点BodyPart,邮件最终由多个BodyPart组成
        MimeBodyPart text_image_body = new MimeBodyPart();
        text_image_body.setContent(text_image);

        // 设置文本和图片，附件的关系（混合大节点）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image_body);
        mm.setSubType("mixed"); // 有附件资源要定义mixed

        // 最终节点添加到邮件中
        message.setContent(mm);
        message.setSentDate(new Date());
        message.saveChanges();

        // 发送一封邮件
        Transport transport = session.getTransport();
        transport.connect(SENDER, AUTHORIZATIONtCODE);
        Transport.send(message);
    }

    /**
     * 包含附件的发送
     * @return
     * @throws MessagingException
     * @throws AddressException
     * @throws UnsupportedEncodingException
     */
    public static void sendFileEmail(String endName, String theme, String content, String filename)
            throws AddressException, MessagingException, UnsupportedEncodingException {

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, AUTHORIZATIONtCODE);
            }
        });

        // 创建邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(SENDER));

        // 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(endName));// 收件人
        // 设置主题
        message.setSubject(theme);
        // 设置邮件正文 第二个参数是邮件发送的类型
// message.setContent("SADAFFAFS","text/html;charset=UTF-8");
        /*
         * 邮件内容的创建：图片和附件
         */
        // 创建图片节点
        // MimeBodyPart image = new MimeBodyPart();
        // DataHandler dh = new DataHandler(new FileDataSource(
        // "C:\\Users\\26062\\Desktop\\web上线项目\\bkt_1_dashgumfree\\assets\\img\\ui-sam.jpg"));
        // // 读取本地文件
        // image.setDataHandler(dh); // 将数据添加到节点
        // image.setContentID("image_id");// 为“节点”设置一个唯一编号（在文本“节点”将引用该ID）

        // 创建文本节点
        // MimeBodyPart text = new MimeBodyPart();
        // 将图片包含到文本内容中
        // text.setContent(content + "<br/><img src='data:image/png;base64," + filename
        // + "'/>",
        // "text/html;charset=UTF-8");

        // 将文本和图片节点结合
        // MimeMultipart text_image = new MimeMultipart();
        // text_image.addBodyPart(text);
        // text_image.addBodyPart(image);
        // text_image.setSubType("related"); // 关联关系 有内嵌资源要定义related

        // 将混合节点封装成普通节点BodyPart,邮件最终由多个BodyPart组成
        // MimeBodyPart text_image_body = new MimeBodyPart();
        // text_image_body.setContent(text_image);

        // 添加附件节点
        MimeBodyPart document = new MimeBodyPart();
        DataHandler dhdoc = new DataHandler(new FileDataSource(filename)); // 读取本地文档
        document.setDataHandler(dhdoc); // 将附件数据添加到节点

        document.setFileName(MimeUtility.decodeText(dhdoc.getName()));
        // 设置附件文件名

        // 设置文本和图片，附件的关系（混合大节点）
        MimeMultipart mm = new MimeMultipart();
        // mm.addBodyPart(text_image_body);
        mm.addBodyPart(document);
        mm.setSubType("mixed"); // 有附件资源要定义mixed

        // 最终节点添加到邮件中
        message.setContent(mm);
        message.setSentDate(new Date());
        message.saveChanges();

        // 发送一封邮件
        Transport transport = session.getTransport();
        transport.connect(SENDER, AUTHORIZATIONtCODE);
        Transport.send(message);
    }

    /**
     * 定时发送邮件所需的重写方法
     */
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        try {
            new email().sendeMail(SENDER, "das", "dsad");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
