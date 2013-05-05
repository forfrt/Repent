package util;

import javax.servlet.http.Cookie;

import org.apache.struts2.interceptor.CookiesAware;

import pojo.Users;

public class CookieTool {
	public CookieTool(){}

	public Cookie[] getCookieUName(Users user){		
		//向session中添加属性:uId,uName
		//TODO: ssid
		System.out.println("------------util.CookieTool.getCookieUName method start------------");
		
		Cookie[] cookies = new Cookie[2];
		cookies[0]=new Cookie("uId", String.valueOf(user.getuId()));
		cookies[1]=new Cookie("uName", user.getuName());
		
		System.out.println("util.CookieTool.getCookieUName.cookies[0].Name:"+cookies[0].getName());
		System.out.println("util.CookieTool.getCookieUName.cookies[0].Value:"+cookies[0].getValue());
		
		System.out.println("util.CookieTool.getCookieUName.cookies[1].Name:"+cookies[1].getName());
		System.out.println("util.CookieTool.getCookieUName.cookies[1].Value:"+cookies[1].getValue());
		
		return cookies;
		
	}
}
