package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class QuitAction extends ActionSupport {
	
	public String execute(){
		System.out.println("------------action.QuitAction.execute method start------------");
		//非注射方式
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Cookie[] cookies=request.getCookies();
		
		session.removeAttribute("uName");
		session.removeAttribute("uId");
		session.removeAttribute("uPhotoUri");
		session.invalidate();
		System.out.println("session cleared!");
//		session=null;
//		session.removeAttribute("uName");
//		session.removeAttribute("ssid");
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			//cookies[i].setMaxAge(0);
			cookies[i].setValue("");
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
			
		}
		System.out.println("cookie cleared!");
		
		return "success";
		
	}
}
