package pojo;

import java.sql.Timestamp;

public class ReMusic {

	private int rmcID;//���۸�����ID��
	
	private int rmID;//ԭ������ID
	
	private int rmuID;//�����˵�ID
	
	private String rmrContent;//���۵�����
	
	private Timestamp rmrDate;//���۵�ʱ��
	
	private int rmrID;//�������˵�ID
	
	private int rmCount;//������ͨ���Ĵ���
	
	private int rmRCount;//���������۵Ĵ���

	public int getRmcID() {
		return rmcID;
	}

	public void setRmcID(int rmcID) {
		this.rmcID = rmcID;
	}

	public int getRmID() {
		return rmID;
	}

	public void setRmID(int rmID) {
		this.rmID = rmID;
	}

	public int getRmuID() {
		return rmuID;
	}

	public void setRmuID(int rmuID) {
		this.rmuID = rmuID;
	}

	public String getRmrContent() {
		return rmrContent;
	}

	public void setRmrContent(String rmrContent) {
		this.rmrContent = rmrContent;
	}

	public Timestamp getRmrDate() {
		return rmrDate;
	}

	public void setRmrDate(Timestamp rmrDate) {
		this.rmrDate = rmrDate;
	}

	public int getRmrID() {
		return rmrID;
	}

	public void setRmrID(int rmrID) {
		this.rmrID = rmrID;
	}

	public int getRmCount() {
		return rmCount;
	}

	public void setRmCount(int rmCount) {
		this.rmCount = rmCount;
	}

	public int getRmRCount() {
		return rmRCount;
	}

	public void setRmRCount(int rmRCount) {
		this.rmRCount = rmRCount;
	}
	
}
