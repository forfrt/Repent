package util;

import javax.servlet.http.HttpSession;

import pojo.Users;

public class SessionTool {

	public void setSessionUName(HttpSession session, Users user) {
		//向session中添加属性:uId,uName
		//TODO: ssid
		System.out.println("------------util.SessionTool.setSessionUName method start------------");
		
		session.setAttribute("uId", String.valueOf(user.getuId()));
		session.setAttribute("uName", user.getuName());
	}
	
	public void setSession(HttpSession session, Users user,String[] keys) {
		for(String key:keys){
			session.setAttribute(key, user.get("key"));
		}
	}

}
