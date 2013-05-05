package pojo;

import java.sql.Timestamp;

public class Articles {
	/*
	 * repent.news
	 */
	public int aId;
	public String aTitle;
	public String aContent;
	public int uId;
	public Timestamp aTime;
	public int aBrCount;
	public int aReCount;
	
	public int getaId() {
		return aId;
	}
	public String getaTitle() {
		return aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public int getuId() {
		return uId;
	}
	public Timestamp getaTime() {
		return aTime;
	}
	public int getaBrCount() {
		return aBrCount;
	}
	public int getaReCount() {
		return aReCount;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void setaTime(Timestamp aTime) {
		this.aTime = aTime;
	}
	public void setaBrCount(int aBrCount) {
		this.aBrCount = aBrCount;
	}
	public void setaReCount(int aReCount) {
		this.aReCount = aReCount;
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
