package impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojo.Essays;
import pojo.Users;
import util.RequestUID;

import dao.DBConn;

public class EssaysImpl {
	
	private Essays essay;
	
	private int UID;
	
	private PreparedStatement pst;
	
	private List<Essays> Essays;
	
	private ResultSet rs;
	
	public EssaysImpl()
	{
		
	}

	
	public String StorageEssays(Essays essays)
	{
		this.essay = essays;
		UID = RequestUID.getUID();
		String sql = "insert into essays(eTitle,eKey,eURI,eAbstract) values (?,?,?) where uID = ?";
		
		try {
			pst = DBConn.getConnection().prepareStatement(sql);
			pst.setString(1, essays.geteTitle());
			pst.setString(2, essays.geteKey());
			pst.setString(3, essays.geteURI());
			pst.setString(4, essays.geteAbstract());
			pst.setInt(5, UID);
			
			pst.execute();
			
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILURE";
		}
		finally{
			try {
				DBConn.getClose();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	public List<Essays> getQuery()
	{
		UID = RequestUID.getUID();
		String sql = "SELECT eTitle,eKey,eDate,eCount,erCount,eGaiyao,ePID,eID from repent_essay where uID = ?";
		try {
			pst = DBConn.getConnection().prepareStatement(sql);
			pst.setInt(1, UID);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				essay = new Essays();
				essay.seteTitle(rs.getString("eTitle"));
				essay.seteKey(rs.getString("eKey"));
				essay.seteTime(rs.getTimestamp("eDate"));
				essay.seteAbstract(rs.getString("eAbstract"));
				essay.seteId(rs.getInt("eID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				rs.close();
				pst.close();
				DBConn.getClose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return Essays == null ? null:Essays;
	}

	public String essayContents(Users user)
	{
		String sql = " ";
		return null;
	}
}
