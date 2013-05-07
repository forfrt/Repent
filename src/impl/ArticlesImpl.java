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

		String insertArticleSql="insert into news(nTitle,nContent,uId) values(?,?,?)";		
		PreparedStatement p=DBConn.getConnection().prepareStatement(insertArticleSql);
		
		System.out.println("impl.ArticlesImpl.composeArticle.article.getaTitle(): "+article.getnTitle());
		System.out.println("impl.ArticlesImpl.composeArticle.article.getaContent(): "+article.getnContent());
		
		p.setString(1, article.getnTitle());//null错误
		p.setString(2, article.getnContent());
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
			DBConn.getClose();
		}
		
	}
	
	public List<Articles> getFirstNArticles(int n) throws SQLException{
		
		System.out.println("------------impl.ArticlesImpl.getFirstNArticles method start------------");
		
		String getFirstNArticlesSql="select nID,nTitle,nContent,nDate,uID from news order by nDate desc limit 0,?;";
		PreparedStatement p=DBConn.getConnection().prepareStatement(getFirstNArticlesSql);
		
		p.setInt(1, n);

		ResultSet set=p.executeQuery();
		List<Articles> list=new ArrayList<Articles>();		
		while(set.next()){
			Articles art=new Articles();
			art.setnId(set.getInt(1));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(1): "+set.getInt(1));
			
			art.setnTitle(set.getString(2));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(2): "+set.getString(2));
			
			art.setnContent((set.getString(3)));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(3): "+set.getString(3));
			
			art.setnTime((set.getTimestamp(4)));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(4): "+set.getTimestamp(4));
			
			art.setuId(set.getInt(5));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(5): "+set.getInt(5));
			
			System.out.println();
			list.add(art);
		}
		set.close();
		p.close();
		DBConn.getClose();
		return list;
	}
	
	public List<Articles> getMoreNArticles(int n,int nId) throws SQLException{
		
		System.out.println("------------impl.ArticlesImpl.getMoreNArticles method start------------");
		String getMoreNArticlesSql=
				"select nID,nTitle,nContent,nDate,uID from news where nID < ? order by nID desc limit 0,?";
		PreparedStatement p=DBConn.getConnection().prepareStatement(getMoreNArticlesSql);
		
		p.setInt(1, nId);
		p.setInt(2, n);
		
		System.out.println(p.toString());
		ResultSet set=p.executeQuery();
		List<Articles> list=new ArrayList<Articles>();
		
		while(set.next()){		
			Articles art=new Articles();

			art.setnId(set.getInt(1));
			
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(1): "+set.getInt(1));
			
			art.setnTitle(set.getString(2));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(2): "+set.getString(2));
			
			art.setnContent((set.getString(3)));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(3): "+set.getString(3));
			
			art.setnTime((set.getTimestamp(4)));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(4): "+set.getTimestamp(4));
			
			art.setuId(set.getInt(5));
			System.out.print("impl.ArticlesImpl.getFirstNArticles.set(5): "+set.getInt(5));
			
			System.out.println();
			list.add(art);
		}
		
		set.close();
		p.close();
		DBConn.getClose();
		
		return list;
	}
}