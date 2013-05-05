package servlet;

import impl.MailImpl;
import impl.UsersImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;  
import javax.mail.internet.*;  

import pojo.Users;


import java.io.IOException;
import java.io.OutputStream;
import java.util.*;  

public class SendEmailServlet extends HttpServlet {
	
	public int sendEmail(String fromEmail,String toEmail,String subject,
			String context,String cc,String bcc) throws MessagingException{
		Session session;
		MimeMessage message;
		
		Properties properties=System.getProperties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "25" );
		
		session=Session.getInstance(properties);
		session.setDebug(true);
		
		message=new MimeMessage(session);
		message.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		if(cc.trim().length()!=0)
			message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		if(bcc.trim().length()!=0)
			message.setRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
		message.setSubject(subject);
		message.setSentDate(new Date());
		
		BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
		mdp.setContent(context,"text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
		Multipart mp=new MimeMultipart();
		mp.addBodyPart(mdp);
		message.setContent(mp);
		
		Transport transport=session.getTransport("smtp");
		transport.connect("smtp.163.com","forfrt@163.com","feng6636");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
		return 1;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		MailImpl sender = new MailImpl();
		sender.setFrom("forfrt@gmail.com");
		sender.setTo("forfrt@163.com");
		sender.setSubject("测试邮件");
		sender.setBody("测试邮件发送成功!");
		sender.setBcc("119267919@qq.com");
		sender.setCc("fxw945@vip.qq.com");
		sender.sendMail();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		doGet(request, response);
	}
	
	
}
