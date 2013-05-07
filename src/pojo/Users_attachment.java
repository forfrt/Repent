package pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.*;

public class Users_attachment {
	public int uId;
	public  Date uDate;
	public  Timestamp uRDate;
	public int uGrade;
	public String uSex;
	
	public int getuId() {
		return uId;
	}
	public Date getuDate() {
		return uDate;
	}
	public Timestamp getuRDate() {
		return uRDate;
	}
	public int getuGrade() {
		return uGrade;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
	public void setuRDate(Timestamp uRDate) {
		this.uRDate = uRDate;
	}
	public void setuGrade(int uGrade) {
		this.uGrade = uGrade;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String Details(){
		return "UID = " + uId;
	}
	public void setuDate(String uDateConvert)
	{
		String pattern = "yyyy-MM-dd";
		DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try{
			uDate = new Date(simpleDateFormat.parse(uDateConvert).getTime());
		}catch(Exception e)
		{
			
		}
	}
}
