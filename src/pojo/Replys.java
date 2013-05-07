package pojo;

import java.sql.Timestamp;

public class Replys {
	/*
	 * repent.renews
	 */
	private int rId;
	
	private int rnId;
	
	private int rmuId;
	
	private String rContent;
	
	private Timestamp rTime;
	
	private int ruID;
	
	private int rsCount;
	
	private int rCount;
	
	
	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public int getRnId() {
		return rnId;
	}


	public void setRnId(int rnId) {
		this.rnId = rnId;
	}


	public int getRmuId() {
		return rmuId;
	}


	public void setRmuId(int rmuId) {
		this.rmuId = rmuId;
	}


	public String getrContent() {
		return rContent;
	}


	public void setrContent(String rContent) {
		this.rContent = rContent;
	}


	public Timestamp getrTime() {
		return rTime;
	}


	public void setrTime(Timestamp rTime) {
		this.rTime = rTime;
	}


	public int getRuID() {
		return ruID;
	}


	public void setRuID(int ruID) {
		this.ruID = ruID;
	}


	public int getRsCount() {
		return rsCount;
	}


	public void setRsCount(int rsCount) {
		this.rsCount = rsCount;
	}


	public int getrCount() {
		return rCount;
	}


	public void setrCount(int rCount) {
		this.rCount = rCount;
	}


	public String Details(){
		return null;
	}
}