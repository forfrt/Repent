package pojo;

public class Email {
	private String from   = null;  //发件人
    private String[] recipients = null;  //收件人,可以多个
    private String subject   = null;  //邮件主题
    private String content   = null;  //邮件内容
    private String contentType  = null;  //邮件内容格式(文本或html)
    private String fileName  = null;  //附件文件名(目前只提供一个附件) 
}
