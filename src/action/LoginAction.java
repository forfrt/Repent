package action;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JComboBox.KeySelectionManager;

import org.apache.struts2.ServletActionContext;

import params.Properties;
import pojo.Users;
import util.CookieTool;
import util.Md5;
import util.SessionTool;
import impl.UsersImpl;
import util.RequestUID;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.transport.http.client.HttpCookie;

public class LoginAction extends ActionSupport{
	private String ssidKey=new Properties().getSsidKey();
	// TODO :remeber_me鎸夐挳鐨勫叿浣撳疄鐜�
	private Users currentUser;
	
	public String execute(){
		//TODO:待优化,特别是从UsersImpl中获得数据并添加到session与request中
		System.out.println("------------action.LoginAction.execute method start------------");
		UsersImpl userImpl=new UsersImpl();
		CookieTool cookieTool=new CookieTool();
		SessionTool sessionTool=new SessionTool();
		
		//ActionContext方式取得request、response、session
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest)cxt.get
				(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response=(HttpServletResponse)cxt.get
				(ServletActionContext.HTTP_RESPONSE);
		HttpSession session=request.getSession();
		
		try {
			String[] loginResultString=userImpl.Login(currentUser);
			if(loginResultString[loginResultString.length-1].equals("success")){
				//这里的问题在于,currentUser的uName的确是null,表单中不要求uName与uId,应从数据库中查找
				currentUser.setuId(new Integer(loginResultString[0]));
				currentUser.setuName(loginResultString[1]);
				currentUser.setuPhotoUri(loginResultString[2]);
				
				System.out.println("action.LoginAction.execute.currentUser.uId: "+currentUser.getuId());
				System.out.println("action.LoginAction.execute.currentUser.uName: "+currentUser.getuName());
				System.out.println("action.LoginAction.execute.currentUser.uPhotoUri: "+currentUser.getuPhotoUri());
				//添加cookie与session,这里都是可直接覆盖的,因此无需判断是否已经存在
				Cookie uNameCookie[]=cookieTool.getCookieUName(currentUser);
				for(Cookie cookie:uNameCookie){
					response.addCookie(cookie);
				}
				String[] keys={"uName","uId","uPhotoUri"};
				sessionTool.setSession(session,currentUser,keys);//鏈皟璇�椋庨櫓

				request.setAttribute("uId", loginResultString[0]);//浼樺寲,瑙ｈ�!
				request.setAttribute("uName", loginResultString[1]);
				request.setAttribute("uPhotoUri", loginResultString[2]);
				
				System.out.println("action.LoginAction.execute.ssidKey: "+ssidKey);
				System.out.println("action.LoginAction.execute.ssid: "+Md5.calcMD5(loginResultString[0]+ssidKey));
				request.setAttribute("ssid", Md5.calcMD5(loginResultString[0]+ssidKey));

				//因为这个action是登录action,涉及到了添加session与cookie...
				//而刚添加的sc无法被SCfilter立刻放入request的attribute中...
				//因此需要在这里手动将uName值添加到request的attribute中...
				//否则会出现request中uName与session中uName不符,即request中uName为上一用户uName...
				//这是由SCfilter在web.xml中高于struts导致的...
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("++++++++++++action.LoginAction.execute method end++++++++++++");
		
		return "failed";		
	}

	public Users getCurrentUser() {
	
		return currentUser;
	
	}

	public void setCurrentUser(Users currentUser) {
	
		this.currentUser = currentUser;

	}

}
