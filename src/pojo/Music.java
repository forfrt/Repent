package pojo;

import java.sql.Timestamp;

public class Music {
	/*
	 * repent.music
	 */
	private int mId;
	private String mTitle;
	private String mTotalTime;
	private Timestamp mTime;
	private int uId;
	private int mCount;
	private int mRCount;
	private int mPId;
	private String mURI;
	public int getmId() {
		return mId;
	}
	public String getmTitle() {
		return mTitle;
	}
	public String getmTotalTime() {
		return mTotalTime;
	}
	public Timestamp getmTime() {
		return mTime;
	}
	public int getuId() {
		return uId;
	}
	public int getmCount() {
		return mCount;
	}
	public int getmRCount() {
		return mRCount;
	}
	public int getmPId() {
		return mPId;
	}
	public String getmURI() {
		return mURI;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public void setmTotalTime(String mTotalTime) {
		this.mTotalTime = mTotalTime;
	}
	public void setmTime(Timestamp mTime) {
		this.mTime = mTime;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}
	public void setmRCount(int mRCount) {
		this.mRCount = mRCount;
	}
	public void setmPId(int mPId) {
		this.mPId = mPId;
	}
	public void setmURI(String mURI) {
		this.mURI = mURI;
	}
	
}
