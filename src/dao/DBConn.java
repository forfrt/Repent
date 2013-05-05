package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private final String databaseName="repent";
	private final String userName="root";
	private final String userPassword="feng6636";
	private final String serverName="localhost";
	private final int portNum=3306;
	private final String url="jdbc:mysql://";
	
	public DBConn(){}
	
	private String getConnectionUrl(){
		return url+serverName+":"+portNum+"/"+databaseName;
	}
	
	public Connection getConnection() throws SQLException{
		String conurl=getConnectionUrl();
		Connection conn=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("mysql驱动加载成功�");
		}catch(Exception e){
			System.out.println("mysql驱动加载失败�");
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(conurl,userName,userPassword);
		return conn;
	}
}
