package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class RequestUID {
	
	private static int UID;
	private static ActionContext ctx;
	private static HttpServletRequest request;
	private static HttpSession session;
	private static int sessionUID;
	
	public static int getUID()
	{
		//request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		System.out.println("++++++++++++++++RequestUID = ++++++++++++++" + request.getAttribute("uId"));
		UID = new Integer((String)request.getAttribute("uId")).intValue();
		return UID;
	}
	
	public static void setRequest(HttpServletRequest request1)
	{
		request = request1;
	}
	
	public static HttpServletRequest getRequest()
	{
		return request;
	}
	
	public static void setSession(HttpSession session1)
	{
		session = session1;
	}
	
	public static HttpSession getSession()
	{
		return session;
	}
	
	public static int getSessionUID()
	{
		sessionUID = new Integer((String)session.getAttribute("uId"));
		System.out.println("Session里面的值是---------------------> " + sessionUID);
		return sessionUID;
	}
}
