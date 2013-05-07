package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static final String databaseName="repent";
	
	private static final String userName="root";
	
	private static final String userPassword="feng6636";
	
	private static final String serverName="localhost";
	
	private static final int portNum=3306;
	
	private static final String url="jdbc:mysql://";
	
	private static Connection conn;
	
	private static String getConnectionUrl(){
		return url+serverName+":"+portNum+"/"+databaseName;
	}
	
	public static Connection getConnection() throws SQLException{
		String conurl=getConnectionUrl();
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("mysql驱动加载成功");
		}catch(Exception e){
			System.out.println("mysql驱动加载失败");
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(conurl,userName,userPassword);
		return conn;
	}
	
	public static void getClose()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
