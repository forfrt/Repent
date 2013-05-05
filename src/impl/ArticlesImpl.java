package impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBConn;

import pojo.Articles;
import pojo.Users;

public class ArticlesImpl {
	public ArticlesImpl(){}
	
	public String composeArticle(Articles article,Users user) throws SQLException{
		System.out.println("------------impl.ArticlesImpl.composeArticle method start------------");
		DBConn conn=new DBConn();
		
		String insertArticleSql="insert into news(nTitle,nContent,uId) values(?,?,?)";
		PreparedStatement p=conn.getConnection().prepareStatement(insertArticleSql);
		System.out.println("impl.ArticlesImpl.composeArticle.article.getaTitle(): "+article.getaTitle());
		System.out.println("impl.ArticlesImpl.composeArticle.article.getaContent(): "+article.getaContent());
		p.setString(1, article.getaTitle());//null错误
		p.setString(2, article.getaContent());
		p.setInt(3, user.uId);
		
		try {
			p.execute();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String strDBError="An error occurs while using impl.ArticlesImpl.composeArticle() method:" +
					"The queryString is: "	+ insertArticleSql.toString() +
					"<p>The Error Information from DBMS"+e.getMessage();
			System.out.println("strDBError");
			e.printStackTrace();
			return "failed";
		}finally{
			p.close();
			conn.getConnection().close();
		}
		
	}
	
	public List<Articles> getFirstNArticles(int n) throws SQLException{
		System.out.println("------------impl.ArticlesImpl.getFirstNArticles method start------------");
		DBConn conn=new DBConn();
		
		String getFirstNArticlesSql="select * from news order by nTime desc limit 0,?;";
		PreparedStatement p=conn.getConnection().prepareStatement(getFirstNArticlesSql);
		p.setInt(1, n);
		System.out.println(p.toString());
		
		ResultSet set=p.executeQuery();
		return getListFromSet(set);
	}
	
	public List<Articles> getMoreNArticles(int n,int aId) throws SQLException{
		System.out.println("------------impl.ArticlesImpl.getMoreNArticles method start------------");
		DBConn conn=new DBConn();
		
		String getMoreNArticlesSql=
				"select * from news where nId < ? order by nId desc limit 0,?";
		PreparedStatement p=conn.getConnection().prepareStatement(getMoreNArticlesSql);
		p.setInt(1, aId);
		p.setInt(2, n);
		
		System.out.println(p.toString());
		
		ResultSet set=p.executeQuery();
		return getListFromSet(set);
	}
	
	private List<Articles> getListFromSet(ResultSet set) throws SQLException{
		System.out.println("------------impl.ArticlesImpl.getListFromSet method start------------");
		List<Articles> list=new ArrayList<Articles>();
		while(set.next()){
			Articles art=new Articles();
			art.setaId(set.getInt(1));
			System.out.print(set.getInt(1));
			
			art.setaTitle(set.getString(2));
			System.out.print(set.getString(2));
			
			art.setaContent((set.getString(3)));
			System.out.print(set.getString(3));
			
			art.setaTime((set.getTimestamp(4)));
			System.out.print(set.getTimestamp(4));
			
			art.setuId(set.getInt(5));
			System.out.print(set.getInt(5));
			
			art.setaBrCount(set.getInt(6));
			System.out.print(set.getInt(6));
			
			art.setaReCount(set.getInt(7));
			System.out.println(set.getInt(7));
			
			System.out.println();
			list.add(art);
		}
		return list;
	}
}