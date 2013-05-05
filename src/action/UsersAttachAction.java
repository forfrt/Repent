package action;
import java.sql.SQLException;

import impl.UsersAttachImp;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Users_attachment;

public class UsersAttachAction extends ActionSupport{
	private Users_attachment currentUser;
	private UsersAttachImp usersAttachImp = new UsersAttachImp();;
	
	public String execute() throws Exception {	
		try{
			return usersAttachImp.UpGrade(currentUser);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "failed";
	}
	
	public String getUsersAttach()
	{
		
		return "";
	}
	
	public void setCurrentUser(Users_attachment currentUser)
	{
		this.currentUser = currentUser;
	}
	
	public Users_attachment getCurrentUser()
	{
		return currentUser;
	}
	
}
