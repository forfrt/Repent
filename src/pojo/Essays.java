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
	
	private int euId;
	
	private String eURI;
	
	private String eAbstract;
	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public String geteKey() {
		return eKey;
	}

	public void seteKey(String eKey) {
		this.eKey = eKey;
	}

	public Timestamp geteTime() {
		return eTime;
	}

	public void seteTime(Timestamp eTime) {
		this.eTime = eTime;
	}

	public int getEuId() {
		return euId;
	}

	public void setEuId(int euId) {
		this.euId = euId;
	}

	public String geteURI() {
		return eURI;
	}

	public void seteURI(String eURI) {
		this.eURI = eURI;
	}

	public String geteAbstract() {
		return eAbstract;
	}

	public void seteAbstract(String eAbstract) {
		this.eAbstract = eAbstract;
	}

	public String Details(){
		return null;
	}	
}
