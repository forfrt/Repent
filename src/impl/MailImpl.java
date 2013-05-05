package impl;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import pojo.Users;

public class MailImpl {

    /** 发信人 */
    private String from;
    /** 收信人 */
    private String to;
    /** 主题 */
    private String subject;
    /** 正文 */
    private String body;
    /** 抄送 */
    private String cc;
    /** 暗送 */
    private String bcc;
    
    private String password="feng6636";
    private String email="forfrt@gmail.com";
   
    public MailImpl() {
       
    }
        /**
         * 发送邮件.
         * @return boolean - 发送结果
         */
        public boolean sendMail() {
            if (getBody() == null || getTo() == null || getFrom() == null
                    || getSubject() == null) { return false; }
            try {
                Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp" );
                props.put("mail.smtp.host", "smtp.gmail.com");
               
                //gmail邮件服务商用端口为465
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
                props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
                props.setProperty("mail.smtp.port", "465"); 
                props.setProperty("mail.smtp.socketFactory.port", "465");
                
                props.put("mail.smtp.auth", "true" );
                Authenticator auth = new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(email,password);
                    }
                };
                
                Session mailSession = Session.getDefaultInstance(props,auth);
                Message msg = new MimeMessage(mailSession);
   
                msg.setFrom(new InternetAddress(getFrom()));
                msg.addRecipients(Message.RecipientType.TO, InternetAddress
                        .parse(getTo()));
                msg.setSentDate(new Date());
                msg.setSubject(getSubject());
                if(cc!=null&&cc.trim().length()!=0)
        			msg.setRecipient(Message.RecipientType.CC, new InternetAddress(getCc()));
        		if(bcc!=null&&bcc.trim().length()!=0)
        			msg.setRecipient(Message.RecipientType.BCC, new InternetAddress(getBcc()));
   
                msg.setText(getBody());
                msg.saveChanges();
                
                System.out.println("正在连接服务器。。。。");
                Transport transport = mailSession.getTransport("smtp");
                transport.connect(props.getProperty("mail.smtp.host"), email, password);
               
                System.out.println("正在发送邮件。。。。");
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                System.out.println("发送完毕。。。。");
   
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
                return false;
            }
            return true;
        }
   
        /**
         * @return Returns the body.
         */
        public String getBody() {
            return body;
        }
   
        /**
         * @param body
         *            The body to set.
         */
        public void setBody(String body) {
            this.body = body;
        }
   
        /**
         * @return Returns the from.
         */
        public String getFrom() {
            return from;
        }
   
        /**
         * @param from
         *            The from to set.
         */
        public void setFrom(String from) {
            this.from = from;
        }
   
        /**
         * @return Returns the subject.
         */
        public String getSubject() {
            return subject;
        }
   
        /**
         * @param subject
         *            The subject to set.
         */
        public void setSubject(String subject) {
            this.subject = subject;
        }
   
        /**
         * @return Returns the to.
         */
        public String getTo() {
            return to;
        }
   
        /**
         * @param to
         *            The to to set.
         */
        public void setTo(String to) {
            this.to = to;
        }
        
        /**
         * @return Returns the cc.
         */
		public String getCc() {
			return cc;
		}
		
		/**
         * @param cc
         *            The cc to set.
         */
		public void setCc(String cc) {
			this.cc = cc;
		}
		
		/**
         * @return Returns the bcc.
         */
		public String getBcc() {
			return bcc;
		}
		
		/**
         * @param bcc
         *            The bcc to set.
         */
		public void setBcc(String bcc) {
			this.bcc = bcc;
		}
		
		private int randomKeyLength=6;
		public String urlFactory(Users user){
			/*
			 * TODO:要不要在数据库中存储一个随机数,通过随机数+uID的方式生成URI
			 * 先发送出去,之后再加加密算法
			 */

			int uId=user.getuId();
			String tokenUrl="uId="+String.valueOf(uId);
			
			return tokenUrl;
		}
        
}