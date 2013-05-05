package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.jndi.cosnaming.CNNameParser;

import dao.DBConn;
import pojo.Users;

public class UsersImpl {
	public UsersImpl(){}
	
	public String[] Login(Users user) throws SQLException{
		//TODO: 待优化,尤其是从ResultSet中取数据并将其返回时---13.04.30 FENGRT
		System.out.println("------------impl.UsersImpl.Login method start------------");
		System.out.println("鎻愪氦鍒癷mpl.UsersImpl.Login method涓殑user淇℃伅:\n"+user.Details());
		DBConn conn=new DBConn();
		String[] result=new String[4];//放uId,uName,uPhotoUri与成功标志
		//通过用户邮箱uMail查表
		String querySql="select * from users where uMail = ? ;";
		PreparedStatement querySta=conn.getConnection().prepareStatement(querySql);
		querySta.setString(1, user.getuEmail());
		
		System.out.println(querySta.toString());
		//获得查询结果,取出uId,uName与uPassword
		//uId,uName是为了放入Session与Cookie
		//uPassword是为了验证
		ResultSet querySet=querySta.executeQuery();
		querySet.next();//
		
		int dbUId=querySet.getInt(1);//uId
		String dbUName=querySet.getString(2);//uName
		String dbUPassword=querySet.getString(3);//uPassword
		String dbUPhotoUri=querySet.getString(3);//uPhoto
		
		//若通过验证则返回uId,uName,uPhotoUri"success"
		if(dbUPassword.equals(user.getuPassword())){
//			System.out.println("琛ㄥ崟鎻愪氦瀵嗙爜: "+user.getuPassword()+" 涓�+"鏁版嵁搴撳瓨鍌ㄥ瘑鐮� "
//		+dbPassword+"鐩哥瓑~");
			querySta.close();
			conn.getConnection().close();
			result[0]=String.valueOf(dbUId);
			result[1]=dbUName;
			result[2]=dbUPhotoUri;
			result[3]="success";
			return result;
		}else{
			querySta.close();
			conn.getConnection().close();
			
			result[2]="failed";
			return result;
		}
	}
	
	/*
	 * 13-05-14 FENGRT
	 */
	public String emailValidate(Users user){
		System.out.println("------------impl.UsersImpl.emailValidate method start------------");
		MailImpl sender = new MailImpl();
		sender.setFrom("forfrt@gmail.com");
		sender.setTo(user.getuEmail());
		sender.setSubject("[忏悔网] 账号激活邮件");
		sender.setBody("localhost:8080/Repent/activateEmail.do?"+sender.urlFactory(user));
		sender.setBcc("forfrt@163.com");
		
		sender.sendMail();
		
		return "failed";
	}
	
	/*
	 * 13-05-14 FENGRT
	 */
	public String[] setActivated(Users user) throws SQLException{
		String[] result=new String[1];
		int uId=user.getuId();
		String activateSql="update users set uActiviated=1 where uId=?";
		PreparedStatement activateSqlSta=new DBConn().getConnection().prepareStatement(activateSql);
		activateSqlSta.setInt(1,user.getuId());
		activateSqlSta.executeUpdate();
		result[0]="success";
		
		return result;
	}
	
	/*
	 * 13-05-04 FENGRT 变动:返回值中加入了uId,为了在验证邮箱时能够获取到
	 */
	public String[] signUp(Users user) throws SQLException{
		System.out.println("------------impl.UsersImpl.signup method start------------");
		String[] result=new String[2];
		System.out.println("鎻愪氦鍒癷mpl.UsersImpl.Login method涓殑user淇℃伅:\n"+user.Details());
		DBConn conn=new DBConn();
		Connection connection=conn.getConnection();
		
		String insertUserSql="insert into users(uName,uPwd,uMail) values(?,?,?)";
		PreparedStatement p=connection.prepareStatement(insertUserSql);
		p.setString(1, user.getuName());
		p.setString(2, user.getuPassword());
		p.setString(3, user.getuEmail());
		System.out.println("impl.UsersImpl.Login.p: "+p.toString());
		
		try {
			p.execute();
			PreparedStatement queryStatement=connection.prepareStatement("select * from users where uMail = ? ;");
			queryStatement.setString(1, user.getuEmail());
			
			System.out.println("impl.UsersImpl.Login.queryStatement: "+queryStatement.toString());
			ResultSet set=queryStatement.executeQuery();
			set.next();
			result[0]=String.valueOf(set.getInt(1));
			System.out.println("impl.UsersImpl.Login.result[0]: "+result[0]);
			result[1]="success";
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String strDBError="An error occurs while using impl.UsersImpl.signUp() method:" +
					"The queryString is: "	+ insertUserSql.toString() +
					"<p>The Error Information from DBMS"+e.getMessage();
			System.out.println("strDBError");
			e.printStackTrace();
			
			result[1]="failed";
			return result;
		}finally{
			p.close();
			conn.getConnection().close();
		}
	}
	//改了uPhoto的类型和名字,小昭注意下---13.04.30 FENGRT
	public Users getQuery(int uID) throws SQLException
	{
		Users  user = new Users();
		String sql = "SELECT uName,uPwd,uPhoto FROM USER WHERE uID = ?";
		
		Connection conn = new DBConn().getConnection();
		
		PreparedStatement psQuery = conn.prepareStatement(sql);
		
		ResultSet rs = null;
		
		rs = psQuery.getResultSet();
		
		while(rs.next())
		{
			user.setuName(rs.getString(1));
			user.setuPassword(rs.getString(2));
			user.setuPhotoUri(rs.getString(3));
		}
		rs.close();
		psQuery.close();
		conn.close();
		
		return user;
	}

}
