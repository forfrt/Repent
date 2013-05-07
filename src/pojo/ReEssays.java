package pojo;

import java.sql.Timestamp;

public class ReEssays {

	private int reID;//评论文章的ID
	
	private int reIID;;//原文章ID
	
	private int ruID;//评论人ID
	
	private String rerContent;//评论内容
	
	private Timestamp rerDate;//评论时间
	
	private int rerID;//被评论人的ID
	
	private int reCount;//文章被浏览次数
	
	private int reRCount;//文章被评论次数

	public int getReID() {
		return reID;
	}

	public void setReID(int reID) {
		this.reID = reID;
	}

	public int getReIID() {
		return reIID;
	}

	public void setReIID(int reIID) {
		this.reIID = reIID;
	}

	public int getRuID() {
		return ruID;
	}

	public void setRuID(int ruID) {
		this.ruID = ruID;
	}

	public String getRerContent() {
		return rerContent;
	}

	public void setRerContent(String rerContent) {
		this.rerContent = rerContent;
	}

	public Timestamp getRerDate() {
		return rerDate;
	}

	public void setRerDate(Timestamp rerDate) {
		this.rerDate = rerDate;
	}

	public int getRerID() {
		return rerID;
	}

	public void setRerID(int rerID) {
		this.rerID = rerID;
	}

	public int getReCount() {
		return reCount;
	}

	public void setReCount(int reCount) {
		this.reCount = reCount;
	}

	public int getReRCount() {
		return reRCount;
	}

	public void setReRCount(int reRCount) {
		this.reRCount = reRCount;
	}
	
}
