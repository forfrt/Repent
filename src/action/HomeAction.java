package action;

import impl.ArticlesImpl;

import java.sql.SQLException;
import java.util.List;

import pojo.Articles;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	private List<Articles> articleList;
	
	public String execute(){
		ArticlesImpl artImpl=new ArticlesImpl();
		try {
			articleList=artImpl.getFirstNArticles(10);
			//user.getuPhoto
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public List<Articles> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Articles> articleList) {
		this.articleList = articleList;
	}
	
}
