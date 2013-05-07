package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConn;

public class DBtest {
	public static void main(String[] args) throws SQLException{
		DBConn dbco=new DBConn();
		Connection conn=dbco.getConnection();
		
		String sql="select * from users;";
		PreparedStatement p=conn.prepareStatement(sql);
		ResultSet set=p.executeQuery();
		
		while(set.next()){
			System.out.println("uId: "+set.getInt(1));
			System.out.println("uName: "+set.getString(2));
		}
	}
}
