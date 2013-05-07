package pojo;

import java.sql.Timestamp;

public class Articles {
	/*
	 * repent.news
	 */
	public int nId;
	public String nTitle;
	public String nContent;
	public int uId;
	public Timestamp nTime;
	
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public Timestamp getnTime() {
		return nTime;
	}
	public void setnTime(Timestamp nTime) {
		this.nTime = nTime;
	}
	
	
//	public String Details(){
//		return "+------+------------+--------------------------------+---------------+--------+--------------------+------------+\n" +
//				"| uId  | uName      | uPassword                      |  uBrithDate   | uGrade | uEmail             | remeber_me |\n" +
//				"+------+------------+--------------------------------+---------------+--------+--------------------+------------+\n" +
//				"|"+String.format("%-6d",this.getuId())+"|"+String.format("%-12s",this.getuName())+
//				"|"+String.format("%-32s",this.getuPassword())+"|"+String.format(" %1$tm %1$te,%1$tY",this.getuBrithdate())+
//				"|"+String.format("%-8s",this.getuGrade())+"|"+String.format("%-20s", this.getuEmail())+
//				"|"+String.format("%-12s",this.getRemember_me())+"|";
//	}
	
	
}
