package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DBConn;

import pojo.Articles;
import pojo.Replys;
import util.RequestUID;
/*
 * 这里面的功能是：
 * 1、对于任何一个帖子得到评论的次数和评论的内容
 * 2、只要有人访问过这个帖子的话说明评论的次数要加一
 * 3、如果有人对这个帖子进行了评论的话那么这个帖子的评论内容和浏览次数都要加一
 * 4、针对某人的一个帖子要显示出帖子和评论的所有的内容
 * 5、某个人的个人空间，他可以看到有关于他的所有帖子以及他对哪些进过哪些评论
 */

public class ReNewsImpl {
	private Replys news;
	private List<Replys> replysList;
	private Articles articles; 
	private List<Articles> articlesList;
	private Connection conn;
	private PreparedStatement pst;
	
	public ReNewsImpl()
	{
	}
	/*
	 * 查询他自己发过的帖子
	 */
	public List<Replys> getQuery()
	{
		List<Replys> list = null;
		String sql = "select nTitle,nContent,nDate from news where uID = ?";
		try {
			conn = DBConn.getConnection();
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, RequestUID.getSessionUID());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				news = new Replys();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
