package action;

import java.sql.SQLException;

import impl.UsersImpl;
import pojo.Users;

import com.opensymphony.xwork2.ActionSupport;

public class SignupAction extends ActionSupport{
	private Users currentUser;
	
	public String execute(){
		System.out.println("------------action.SignupAction.execute method start------------");
		UsersImpl userImpl=new UsersImpl();
		try {
			String[] result=userImpl.signUp(currentUser);
			if(result[result.length-1].equalsIgnoreCase("success")){
				currentUser.setuId(new Integer(result[0]));
				System.out.println("action.SignupAction.execute.currentUser.uEmail: "+currentUser.getuEmail());
				userImpl.emailValidate(currentUser);
			}
			
			return "success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return "failed";
	}
	
	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}
}

