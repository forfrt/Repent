package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConn;

import pojo.Users_attachment;

public class UsersAttachImp{
	public UsersAttachImp()
	{
		
	}
	
	public String UpGrade(Users_attachment currentUser)throws SQLException
	{
		System.out.println("------------impl.UsersAtachImpl.UpGrade method start------------");
		System.out.println("提交到impl.UsersImpl.Login method中的user信息:\n"+currentUser.Details());
		DBConn DConn = new DBConn();
		Connection conn = DConn.getConnection();
		
		String sql = "UPDATE USERATTACH set aDate = ? and aSex = ? where uID = ?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setDate(1, currentUser.getuDate());
		p.setString(2, new Byte(currentUser.getuSex()).toString());
		try{
			p.execute();
			return "success";
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "fail";
		}
		finally{
			p.close();
			conn.close();
		}
		
	}
	
	public Users_attachment getQuery(int uID) throws SQLException
	{
		System.out.println("------------impl.UsersAtachImpl.getQuery method start------------");
		Users_attachment user = new Users_attachment();
		Connection conn = new DBConn().getConnection();
		String sql = "SELECT aDate,aSex from userattach where uID = ?";
		PreparedStatement psQuery = conn.prepareStatement(sql);
		
		psQuery.setInt(1, uID);
		
		ResultSet rs = psQuery.getResultSet();
		
		while(rs.next())
		{
			user.setuDate(rs.getDate(1));
			user.setuSex(new Byte(rs.getString(2)));
		}
		rs.close();
		psQuery.close();
		conn.close();
		return user;
	}
}
