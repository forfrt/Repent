package pojo;

import java.sql.Timestamp;

public class Essays {
	/*
	 * repent.news
	 */
	private int eId;
	private String eTitle;
	private String eKey;
	private Timestamp eTime;
	private int uId;
	private int eCount;
	private int eRCount;
	private String eURI;
	private String eOutline;
	private int ePId;
	public int geteId() {
		return eId;
	}
	public String geteTitle() {
		return eTitle;
	}
	public String geteKey() {
		return eKey;
	}
	public Timestamp geteTime() {
		return eTime;
	}
	public int getuId() {
		return uId;
	}
	public int geteCount() {
		return eCount;
	}
	public int geteRCount() {
		return eRCount;
	}
	public String geteURI() {
		return eURI;
	}
	public String geteOutline() {
		return eOutline;
	}
	public int getePId() {
		return ePId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public void seteKey(String eKey) {
		this.eKey = eKey;
	}
	public void seteTime(Timestamp eTime) {
		this.eTime = eTime;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void seteCount(int eCount) {
		this.eCount = eCount;
	}
	public void seteRCount(int eRCount) {
		this.eRCount = eRCount;
	}
	public void seteURI(String eURI) {
		this.eURI = eURI;
	}
	public void seteOutline(String eOutline) {
		this.eOutline = eOutline;
	}
	public void setePId(int ePId) {
		this.ePId = ePId;
	}
	public String Details(){
		return null;
	}
	
	
}
