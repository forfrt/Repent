package pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Users_attachment {
	/*
	 * repent.userattach
	 */
	private int uId;
	private Date uDate;
	private Timestamp uRDate;
	private int uGrade;
	private byte uSex;
	private byte[] uPhoto;
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
	public byte getuSex() {
		return uSex;
	}
	public byte[] getuPhoto() {
		return uPhoto;
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
	public void setuSex(byte uSex) {
		this.uSex = uSex;
	}
	public void setuPhoto(byte[] uPhoto) {
		this.uPhoto = uPhoto;
	}
	public String Details(){
		return "UID = " + uId;
	}
}
