package pojo;

import java.sql.Timestamp;

public class Music {
	/*
	 * repent.music
	 */
	private int mId;//音乐存进去时的ID

	private String mTitle;//歌曲名
	
	private Timestamp mTime;//歌曲存进去时的时间
	
	private int muId;//发布人的ID
	
	private String mRUI;//歌曲所存的URI

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public Timestamp getmTime() {
		return mTime;
	}

	public void setmTime(Timestamp mTime) {
		this.mTime = mTime;
	}

	public int getMuId() {
		return muId;
	}

	public void setMuId(int muId) {
		this.muId = muId;
	}

	public String getmRUI() {
		return mRUI;
	}

	public void setmRUI(String mRUI) {
		this.mRUI = mRUI;
	}
		
}
