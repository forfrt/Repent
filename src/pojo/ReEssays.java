package pojo;

import java.sql.Timestamp;

public class ReEssays {

	private int reID;//�������µ�ID
	
	private int reIID;;//ԭ����ID
	
	private int ruID;//������ID
	
	private String rerContent;//��������
	
	private Timestamp rerDate;//����ʱ��
	
	private int rerID;//�������˵�ID
	
	private int reCount;//���±��������
	
	private int reRCount;//���±����۴���

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
