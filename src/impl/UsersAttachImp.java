package impl;

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
		System.out.println("------------impl.Users_attachment UpGrade method start------------");
		
		String sql = "UPDATE users_attach set abDate = ? and auSex = ? where uID = ?";
		PreparedStatement p = DBConn.getConnection().prepareStatement(sql);
		p.setDate(1, currentUser.getuDate());
		p.setString(2, new Byte(currentUser.getuSex()).toString());
		try{
			p.execute();
			return "SUCCESS";
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "FAILURE";
		}
		finally{
			p.close();
			DBConn.getClose();
		}
		
	}
	
	public Users_attachment getQuery(int uID) throws SQLException
	{
		Users_attachment user_attachment = new Users_attachment();
		String sql = "SELECT abDate,auGrade,auSex,arDate from users_attach where uID = ?";
		PreparedStatement psQuery = DBConn.getConnection().prepareStatement(sql);
		
		psQuery.setInt(1, uID);
		psQuery.execute();
		ResultSet rs = psQuery.getResultSet();
		
		//System.out.println(rs.next());
		while(rs.next())
		{
			user_attachment.setuDate(rs.getDate(1));
			user_attachment.setuGrade(rs.getInt(2));
			user_attachment.setuSex(rs.getString(3));
			user_attachment.setuRDate(rs.getTimestamp(4));
		}
		
		rs.close();
		psQuery.close();
		DBConn.getClose();
		
		return user_attachment;
	}
}
