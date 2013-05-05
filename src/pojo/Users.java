package pojo;

import java.sql.Blob;
import java.sql.Date;

public class Users {
	/*
	 * repent.user
	 */
	public int uId;
	public String uName;
	public String uPassword;
	public String uEmail;
	public String remember_me;
	public String uPhotoUri;
	
	public Users(){}
	
	public Users(String uName,String uPassword,String uEmail){
		setuName(uName);
		setuEmail(uEmail);
		setuPassword(uPassword);
	}
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getRemember_me() {
		return remember_me;
	}
	public void setRemember_me(String remember_me) {
		this.remember_me = remember_me;
	}
	public String getuPhotoUri() {
		return uPhotoUri;
	}

	public void setuPhotoUri(String uPhotoUri) {
		this.uPhotoUri = uPhotoUri;
	}

	public String get(String key){
		//所有属性都可以从该方法获得
		if(key.equalsIgnoreCase("uId")){
			return String.valueOf(getuId());
		}else if(key.equalsIgnoreCase("uName")){
			return getuName();
		}else if(key.equalsIgnoreCase("uEmail")){
			return getuEmail();
		}else if(key.equalsIgnoreCase("remember_me")){
			return getRemember_me();
		}else if(key.equalsIgnoreCase("uPhoto")){
			return getuPhotoUri();
		}else{
			return null;
		}
	}
	
	public String Details(){
		return "+------+------------+--------------------------------+---------------+--------+--------------------+------------+\n" +
				"| uId  | uName      | uPassword                      | uEmail             | remeber_me |\n" +
				"+------+------------+--------------------------------+---------------+--------+--------------------+------------+\n" +
				"|"+String.format("%-6d",this.getuId())+"|"+String.format("%-12s",this.getuName())+
				"|"+String.format("%-32s",this.getuPassword())+"|"+String.format("%-20s", this.getuEmail())+
				"|"+String.format("%-12s",this.getRemember_me())+"|";
	}
	
}
