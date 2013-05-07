package action;

import java.sql.SQLException;

import impl.ArticlesImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import pojo.Articles;
import pojo.Users;
import util.RequestTool;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ComposeAction {
	private Articles composedArticle;
	private Users currentUser;
	
	public String execute(){
		System.out.println("------------action.ComposeAction.execute method start------------");
		currentUser=new Users();
		
		//非注射方式取得上下文
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest)cxt.get
				(ServletActionContext.HTTP_REQUEST);
		//取得当前用户uId,uName
		String RequestuName=new RequestTool().getValue(request,"uName");
//		int RequestuId=new Integer(new RequestTool().getValue(request,"uId"));//问题
		
		System.out.println("action.ComposeAction.execute.request.getAttribute('uId'): "+request.getAttribute("uId"));
		
		int RequestuId=new Integer((String)request.getAttribute("uId")) ;
		
		System.out.println("action.ComposeAction.execute.RequestuName: "+RequestuName);
		
		System.out.println("action.ComposeAction.execute.RequestuId: "+RequestuId);
		
		currentUser.setuId(RequestuId);
		
		currentUser.setuName(RequestuName);
		
		try {
			return new ArticlesImpl().composeArticle(composedArticle, currentUser);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		
	}

	public Articles getComposedArticle() {
		return composedArticle;
	}

	public Users getCurrentUser() {
		return currentUser;
	}

	public void setComposedArticle(Articles composedArticle) {
		this.composedArticle = composedArticle;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}
	
}
