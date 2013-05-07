package action;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import impl.UsersAttachImp;
import impl.UsersImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.Users;
import pojo.Users_attachment;
import util.RequestUID;

public class UsersAttachAction extends ActionSupport{
	private Users_attachment currentUser;
	private Users user;
	private UsersImpl usersImpl = new UsersImpl();
	private Users_attachment users_attachment;
	private UsersAttachImp usersAttachImp = new UsersAttachImp();
	private int uID;
	ActionContext cxt = ActionContext.getContext(); 

	private void getUID()
	{
		uID = RequestUID.getSessionUID();//莫名奇妙!没有把session传过去如何get!
		System.out.println("sessionUID ----------------------------------------->>>>>>>>>>>>>" + uID);
	}
	
	public String getInfoUsers()
	{
		
		getUID();
		try {
			user = usersImpl.getQuery(uID);
			HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
			if(user != null)
			{
				System.out.println("用户名 " + user.getuName() + "  密码  " + user.getuPassword());
				
				request.setAttribute("user", user);
				RequestUID.getSession().setAttribute("user", user);
			}
			else
				request.setAttribute("userAttachment", null);
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FALIURE";
		}
	}
	
	public String getUsersAttach()
	{
		System.out.println("-----------------------------------------------------");
		getUID();
		Users_attachment userAttach;
		try {
			userAttach = usersAttachImp.getQuery(uID);
			HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
			if(userAttach != null)
			{
				request.setAttribute("userAttachment", userAttach);
				RequestUID.getSession().setAttribute("userAttachment", userAttach);
			}
			else
				request.setAttribute("userAttachment", null);
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILURE";
		}
	}
	
	public void setCurrentUser(Users_attachment currentUser)
	{
		this.currentUser = currentUser;
		System.out.println("作者的各种信息是      " + currentUser.getuDate());
		System.out.println("作者的各种信息是      " + currentUser.getuSex());
	}
	
	public Users_attachment getCurrentUser()
	{
		return currentUser;
	}
	
	public String getInfo()
	{
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
		RequestUID.setSession(request.getSession());
		if(getInfoUsers().equalsIgnoreCase("SUCCESS") && getUsersAttach().equalsIgnoreCase("SUCCESS") )
			return "SUCCESS";
		else
			return "FAILURE";
	}
	
	public void setUser(Users user)
	{
		this.user = user;
	}
	
	public Users getUser()
	{
		return user;
	}
	
	public String updateUsers_attach() throws SQLException
	{
			return usersAttachImp.UpGrade(users_attachment);
	}
	
	public String updateUsers()
	{
		return usersImpl.updateUsers(user);
	}
	
	public String update()
	{
		try {
			if(updateUsers_attach().equalsIgnoreCase("SUCCESS"))
			{
				return "SUCCESS";
			}
			else
			{
				return "FAILURE";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILURE";
		}
	}
}
