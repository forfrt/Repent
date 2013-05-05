package pojo;

import java.sql.Timestamp;

public class Replys {
	/*
	 * repent.renews
	 */
	private int rId;
	private int nId;
	private int uId;
	private String rContent;
	private Timestamp rTime;
	public int getrId() {
		return rId;
	}
	public int getnId() {
		return nId;
	}
	public int getuId() {
		return uId;
	}
	public String getrContent() {
		return rContent;
	}
	public Timestamp getrTime() {
		return rTime;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public void setrTime(Timestamp rTime) {
		this.rTime = rTime;
	}
	public String Details(){
		return null;
	}
}